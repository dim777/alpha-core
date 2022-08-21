package tech.ineb.ats.alpha.observer;

public interface DataFabric<T extends Observer, U> {
    void register(T observer);
    void remove(T observer);
    void push(U data);
}
