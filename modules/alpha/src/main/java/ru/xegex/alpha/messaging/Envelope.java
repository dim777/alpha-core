package ru.xegex.alpha.messaging;

import java.io.Serializable;

/**
 * Envelope with messageType defined class
 */
public final class Envelope<T> implements Serializable {
    private static final long serialVersionUID = 4268801052358035098L;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
