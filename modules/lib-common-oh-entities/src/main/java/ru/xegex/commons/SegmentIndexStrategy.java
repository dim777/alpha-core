package ru.xegex.commons;

/**
 * Return segment reference for specific index
 *
 * @param <S> segment
 * @author dim777
 */
public interface SegmentIndexStrategy<S extends SegmentIndex<Segment<T>, T>, T> {
  /**
   * Calculate index in segment
   *
   * @param idx         main index
   * @param segmentsLen segments length
   * @return segmentIndex
   */
  S calculate(long idx, int segmentsLen);


  static <E> SegmentIndexStrategy<SegmentIndex<Segment<E>, E>, E> defaultSegmentIdxStrategy() {
    //fixme: temp impl
    throw new RuntimeException();
  }
}