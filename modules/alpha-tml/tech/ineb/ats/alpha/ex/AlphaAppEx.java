package tech.ineb.ats.alpha.ex;

public class AlphaAppEx extends RuntimeException {
    public AlphaAppEx() {
        super();
    }

    public AlphaAppEx(String message) {
        super(message);
    }

    public AlphaAppEx(String message, Throwable cause) {
        super(message, cause);
    }

    public AlphaAppEx(Throwable cause) {
        super(cause);
    }
}
