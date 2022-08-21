package tech.ineb.lib.common.models.ex;

public class OrderTypeNotFoundEx extends RuntimeException {
    public OrderTypeNotFoundEx() {
        super();
    }

    public OrderTypeNotFoundEx(String message) {
        super(message);
    }

    public OrderTypeNotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderTypeNotFoundEx(Throwable cause) {
        super(cause);
    }
}
