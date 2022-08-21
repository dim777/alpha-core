package tech.ineb.svc.data.api.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import tech.ineb.lib.common.models.rest.CommonReq;
import tech.ineb.lib.common.models.rest.QuoteSeriesRequest;
import tech.ineb.svc.data.api.ex.NotValidQuoteRequest;

import java.time.LocalDate;
import java.util.UUID;

@RestController(value = "/api/v1/quotes") @AllArgsConstructor @Slf4j
public class QuotesController {
  /**
   * Update quotes
   * @param providerCode Market Data Provider Code
   * @param seriesRequest
   * @return
   */
  @RequestMapping(value = "/update/{providerCode}", method = RequestMethod.POST, produces = "application/json")
  public ResponseEntity<Void> updateQuoteSeries(@PathVariable String providerCode,
                                                @RequestBody @NonNull CommonReq<QuoteSeriesRequest> seriesRequest) {
    final UUID correlationId = seriesRequest.getCorrelationId();
    log.info("Update quote series with correlation ID = '{}'", correlationId);

    QuoteSeriesRequest payload = seriesRequest.getPayload();
    LocalDate from = payload.getFrom();
    LocalDate till = payload.getTill();

    if (!from.isBefore(till)) {
      throw new NotValidQuoteRequest("Dates in request is not valid");
    }

    return ResponseEntity.noContent().build();
  }
}
