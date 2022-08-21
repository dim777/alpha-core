package tech.ineb.lib.common.models.ex;

public class OrderStatusNotFoundEx extends RuntimeException {
    public OrderStatusNotFoundEx() {
        super();
    }

    public OrderStatusNotFoundEx(String message) {
        super(message);
    }

    public OrderStatusNotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderStatusNotFoundEx(Throwable cause) {
        super(cause);
    }
}
