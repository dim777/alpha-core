package ru.xegex.alpha.messaging.ex;

public class SerDeEx extends RuntimeException {
    public SerDeEx(String message) {
        super(message);
    }

    public SerDeEx(String message, Throwable cause) {
        super(message, cause);
    }
}
