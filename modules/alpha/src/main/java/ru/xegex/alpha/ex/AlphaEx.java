package ru.xegex.alpha.ex;

public class AlphaEx extends RuntimeException {
    public AlphaEx(String message) {
        super(message);
    }

    public AlphaEx(String message, Throwable cause) {
        super(message, cause);
    }
}
