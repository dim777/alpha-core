package ru.xegex.commons;

import jdk.internal.misc.Unsafe;
import org.openjdk.jmh.annotations.Benchmark;

import java.nio.ByteBuffer;
import java.util.Random;

public class CompareOffOnHeap {
    private static final int SIZE = 1000 * 1024 * 1024;
    private static final int REPS = 100_000_000;
    private static final int RW_RATIO = 20; //80% writes

    private static ByteBuffer BUF = ByteBuffer.allocate(SIZE);
    private static ByteBuffer BUF_DIRECT = ByteBuffer.allocateDirect(SIZE);
    private static Unsafe UNSAFE = Unsafe.getUnsafe();
    private static long ADDRESS;

    static {
        ADDRESS = UNSAFE.allocateMemory(SIZE);
    }

    @Benchmark
    public void buffer100PctReadOnHeap() {
        Random rnd = new Random(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            BUF.getInt(offset);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }

    @Benchmark
    public void buffer100PctReadOffHeap() {
        Random rnd = new Random(System.currentTimeMillis());

        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            BUF_DIRECT.getInt(offset);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }

    @Benchmark
    public void unsafe100PctReadTest() {
        Random rnd = new Random(System.currentTimeMillis());

        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            UNSAFE.getInt(ADDRESS + offset);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }

    @Benchmark
    public void buffer100PctWriteOnHeap() {
        Random rnd = new Random(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            BUF.putInt(offset, RW_RATIO);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }

    @Benchmark
    public void buffer100PctWriteOffHeap() {
        Random rnd = new Random(System.currentTimeMillis());

        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            BUF_DIRECT.putInt(offset, RW_RATIO);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }

    @Benchmark
    public void unsafe100PctWriteTest() {
        Random rnd = new Random(System.currentTimeMillis());

        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            UNSAFE.putInt(ADDRESS + offset, RW_RATIO);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }

    @Benchmark
    public void buffer100PctMixedOnHeap() {
        Random rnd = new Random(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            if (rnd.nextInt(100) < RW_RATIO) {
                BUF.getInt(offset);
            } else {
                BUF.putInt(offset, RW_RATIO);
            }
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }

    @Benchmark
    public void buffer100PctMixedOffHeap() {
        Random rnd = new Random(System.currentTimeMillis());

        long start = System.currentTimeMillis();
        for (int i = 0; i < REPS; i++) {
            int offset = rnd.nextInt(SIZE - 4);
            if (rnd.nextInt(100) < RW_RATIO) {
                BUF_DIRECT.getInt(offset);
            } else {
                BUF_DIRECT.putInt(offset, RW_RATIO);
            }
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(REPS + " reps = " + elapsed + " milliseconds");
    }
}
