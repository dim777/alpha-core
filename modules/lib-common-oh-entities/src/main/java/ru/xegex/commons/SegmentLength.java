package ru.xegex.commons;

/**
 * Segment length
 */
public interface SegmentLength {
    int calculate(long capacity, int segmentsLen);

    static int defaultSegmentLengthStrategy(long capacity, int segmentsLength) {
        long r = segmentsLength % capacity;
        long l = capacity / segmentsLength;
        if (r == 0) {
            return (int) l;
        }
        return (int) ((l + 1) * segmentsLength) / segmentsLength;
    }
}
