package tech.ineb.ats.alpha.observer;

import java.util.List;

public interface Observer<T> {
    void update(T data);

    void updateAll(List<T> data);
}
