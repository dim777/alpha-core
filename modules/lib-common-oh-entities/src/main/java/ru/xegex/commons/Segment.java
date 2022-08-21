package ru.xegex.commons;

import ru.xegex.commons.mm.MemoryModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Segment<E> implements AutoCloseable {
    private final E flyweight;
    private final AtomicReference<E> last = new AtomicReference<>();
    private final long flyweightSize;

    private int lastIdx = 0;
    private final int segmentLength;

    private final MemoryModel mm;
    private long address;

    class Node<E> {
        private final E el;

        public Node(E el) {
            this.el = el;
        }
    }

    public Segment(MemoryModel mm, Class<E> clazz, int size) {
        if (Objects.isNull(mm) || Objects.isNull(clazz)) throw new XCommonsEx("Constructor vars is not initialized");

        try {
            Constructor<E> constructor = clazz.getConstructor();
            constructor.setAccessible(true);
            flyweight = clazz.getConstructor().newInstance();
        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            throw new XCommonsEx("Couldn't create new flyweight instance");
        }

        this.mm = mm;
        this.flyweightSize = mm.sizeOf(flyweight);
        this.segmentLength = size;
        this.address = mm.getUnsafe().allocateMemory(size * flyweightSize);
    }

    E get(int idx) {
        long from = address + flyweightSize * idx;
        mm.getUnsafe().putAddress(flyweight, flyweightSize, from);

        long to = mm.getUnsafe().getAddress(flyweight, flyweightSize);
        long to1 = mm.getInstanceAddress(flyweight);

        return flyweight;

//        long from = address + flyweightSize * index;
//        long to = mm.getInstanceAddress(flyweight);
//        mm.getUnsafe().copyMemory(from, to, flyweightSize);
//        return flyweight;
    }

    boolean add(E el) {
        do {
            lastIdx++;

            long to = address + flyweightSize * lastIdx;
            long from = mm.getInstanceAddress(el);

            mm.getUnsafe().copyMemory(from, to, flyweightSize);

            if (last.compareAndSet(el, null)) return true;
            else throw new XCommonsEx("Add element failure event");
        }
        while (!last.compareAndSet(null, el));
    }

    @Override
    public void close() {
        mm.getUnsafe().freeMemory(address);
    }
}
