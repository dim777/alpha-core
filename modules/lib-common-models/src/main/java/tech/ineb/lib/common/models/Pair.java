package tech.ineb.lib.common.models;

public final class Pair<T, U> {
  private final T first;
  private final U second;

  public static <T, U> Pair<T, U> of(T first, U second) {
    return new Pair<>(first, second);
  }

  private Pair(T first, U second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public U getSecond() {
    return second;
  }
}