package tech.ineb.svc.data.api.ex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SvcImportDataAppEx extends RuntimeException {
  SvcImportDataAppEx(String message, Throwable cause) {
    super(message, cause);
    log.debug("Get following AthleteNotFoundEx = {}", message);
  }

  SvcImportDataAppEx(String message) {
    super(message);
    log.debug("Get following AthleteNotFoundEx = {}", message);
  }
}
