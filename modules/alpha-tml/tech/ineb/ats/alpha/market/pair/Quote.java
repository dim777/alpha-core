package tech.ineb.ats.alpha.market.pair;

public interface Quote<T, S> {
    T open();

    void open(T data);

    S security();
}
