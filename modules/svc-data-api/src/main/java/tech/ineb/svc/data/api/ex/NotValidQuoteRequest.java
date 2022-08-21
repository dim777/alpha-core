package tech.ineb.svc.data.api.ex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotValidQuoteRequest extends SvcImportDataAppEx {
  public NotValidQuoteRequest(String message, Throwable cause) {
    super(message, cause);
    log.debug("Get following AthleteNotFoundEx = {}", message);
  }

  public NotValidQuoteRequest(String message) {
    super(message);
    log.debug("Get following AthleteNotFoundEx = {}", message);
  }
}
