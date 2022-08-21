package tech.ineb.ats.alpha.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BDataFabric<T extends Observer<U>, U> implements DataFabric<T, U> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BDataFabric.class);

    private List<T> observers = new ArrayList<>();

    @Override
    public void register(T observer) {
        observers.add(observer);
        LOGGER.debug("Registered new observer='{}'", observer);
    }

    @Override
    public void remove(T observer) {
        observers.remove(observer);
        LOGGER.debug("Removed observer='{}'", observer);
    }

    @Override
    public void push(U data) {
        observers.forEach(o -> {
            o.update(data);
            LOGGER.debug("Send message to observer='{}'", data);
        });
    }
}
