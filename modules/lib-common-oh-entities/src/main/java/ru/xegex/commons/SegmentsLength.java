package ru.xegex.commons;

/**
 * Size of segments array
 */
public interface SegmentsLength {
    int calculate(long capacity);

    static int defaultSegmentsLength(long s) {
        return (int) Math.round(Math.log(s));
    }
}
