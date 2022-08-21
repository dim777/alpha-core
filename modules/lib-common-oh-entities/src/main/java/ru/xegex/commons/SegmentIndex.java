package ru.xegex.commons;

import java.util.Objects;

public class SegmentIndex<S extends Segment<E>, E> {
    private final S segment;
    private final int index;

    public SegmentIndex(S segment, int index) {
        this.segment = segment;
        this.index = index;
    }

    public S getSegment() {
        return segment;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SegmentIndex<?, ?> that = (SegmentIndex<?, ?>) o;
        return index == that.index &&
                Objects.equals(segment, that.segment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segment, index);
    }

    @Override
    public String toString() {
        return "SegmentIndex{" +
                "segment=" + segment +
                ", index=" + index +
                '}';
    }
}
