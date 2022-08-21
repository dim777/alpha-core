package tech.ineb.lib.common.models.ex;

public class IntervalUnitNotFoundEx extends RuntimeException {
  public IntervalUnitNotFoundEx() {
    super();
  }

  public IntervalUnitNotFoundEx(String message) {
    super(message);
  }

  public IntervalUnitNotFoundEx(String message, Throwable cause) {
    super(message, cause);
  }

  public IntervalUnitNotFoundEx(Throwable cause) {
    super(cause);
  }
}
