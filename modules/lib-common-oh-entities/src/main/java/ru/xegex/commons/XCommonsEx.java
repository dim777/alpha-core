package ru.xegex.commons;

public class XCommonsEx extends RuntimeException {
    public XCommonsEx() {
    }

    public XCommonsEx(String message) {
        super(message);
    }

    public XCommonsEx(String message, Throwable cause) {
        super(message, cause);
    }

    public XCommonsEx(Throwable cause) {
        super(cause);
    }
}
