package ru.xegex.commons;

import ru.xegex.commons.mm.MemoryModel;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Off heap ticks array list
 *
 * @author dim777
 */
public class XArrayList<E> implements List<E> {
    private final AtomicLong capacity;
    private final AtomicLong globalIdx;

    private final AtomicReferenceArray<Segment<E>> segments;

    private final int segmentsLength;
    private final int segmentLength;

    private final SegmentIndexStrategy<SegmentIndex<Segment<E>, E>, E> segmentIndexStrategy;

    /**
     * public int sizeOf(String klass) {
     * if (klass.equals("byte")) {
     * return 1;
     * } else if (klass.equals("boolean")) {
     * return 1;
     * } else if (klass.equals("short")) {
     * return 2;
     * } else if (klass.equals("char")) {
     * return 2;
     * } else if (klass.equals("int")) {
     * return 4;
     * } else if (klass.equals("float")) {
     * return 4;
     * } else if (klass.equals("long")) {
     * return 8;
     * } else {
     * return klass.equals("double") ? 8 : 4;
     * }
     * }
     *
     * @param clazz clazz
     */
    private XArrayList(Class<E> clazz, long capacity, MemoryModel mm,
                       SegmentsLength segmentsLength,
                       SegmentLength segmentLength,
                       SegmentIndexStrategy<SegmentIndex<Segment<E>, E>, E> segmentIndexStrategy) {
        this.capacity = capacity == 0 ? new AtomicLong(1024) : new AtomicLong(capacity);
        this.segmentsLength = segmentsLength.calculate(this.capacity.get());
        this.segmentLength = segmentLength.calculate(this.capacity.get(), this.segmentsLength);

        Segment<E>[] segments = new Segment[this.segmentsLength];

        for (int i = 0; i < this.segmentsLength; i++) {
            segments[i] = new Segment<>(mm, clazz, this.segmentLength);
        }

        this.segments = new AtomicReferenceArray<>(segments);

        this.segmentIndexStrategy = (idx, segmentsLen) -> {
            int segmentIdx = (int) (idx % segmentsLen);
            Segment<E> segment = this.segments.get(segmentIdx);

            int sIdx = (int) (idx % (this.segmentsLength * this.segmentLength));
            SegmentIndex<Segment<E>, E> segmentIndex = new SegmentIndex<>(segment, sIdx);

            return segmentIndex;
        };

        this.globalIdx = new AtomicLong();

    }

    @Override
    public int size() {
        return (int) this.globalIdx.get();
    }

    @Override
    public boolean isEmpty() {
        return globalIdx.get() == 0;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < globalIdx.get(); i++) {
            E e = this.get(i);
            if (Objects.equals(e, o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E el) {
        long idx = globalIdx.get();

        SegmentIndex<Segment<E>, E> segmentIndex = segmentIndexStrategy.calculate(idx, segmentsLength);
        Segment<E> segment = segmentIndex.getSegment();
        segment.add(el);

        while (true) {
            var oldIdx = globalIdx.get();
            var newIdx = oldIdx + 1;
            if (globalIdx.compareAndSet(oldIdx, newIdx)) {
                return true;
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        while (true) {
            SegmentIndex<Segment<E>, E> segmentIndex = segmentIndexStrategy.calculate(index, segments.length());
            var segment = segmentIndex.getSegment();
            var idx = segmentIndex.getIndex();
            return segment.get(idx);
        }
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    /**
     * capacity - initial capacity
     *
     * @param <T> generic
     */
    public static class Builder<T> {
        private Class<T> clazz;
        private long capacity;
        private MemoryModel mm;
        private SegmentsLength segmentsLength;
        private SegmentLength segmentLength;
        private SegmentIndexStrategy<SegmentIndex<Segment<T>, T>, T> segmentIndexStrategy;

        private Builder() {
        }

        public Builder<T> clazz(Class<T> clazz) {
            this.clazz = clazz;
            return this;
        }

        public Builder<T> capacity(long capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder<T> mm(MemoryModel mm) {
            this.mm = mm;
            return this;
        }

        public Builder<T> segmentsLen(SegmentsLength segmentsLength) {
            this.segmentsLength = segmentsLength;
            return this;
        }

        public Builder<T> segmentLen(SegmentLength segmentLength) {
            this.segmentLength = segmentLength;
            return this;
        }

        public Builder<T> segmentIdxStrategy(SegmentIndexStrategy<SegmentIndex<Segment<T>, T>, T> segmentIndexStrategy) {
            this.segmentIndexStrategy = segmentIndexStrategy;
            return this;
        }

        public XArrayList<T> build() {
            if (Objects.isNull(clazz)) throw new XCommonsEx("Class<T> should be defined");
            return new XArrayList<>(clazz, capacity, mm, segmentsLength, segmentLength, segmentIndexStrategy);
        }
    }
}
