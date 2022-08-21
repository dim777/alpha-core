package tech.ineb.adp.api.tcs.service;

import reactor.core.publisher.Flux;
import tech.ineb.lib.common.models.Quote;
import tech.ineb.lib.common.models.TimeFrame;

import java.time.LocalDate;

public interface QuotesService {
  String getQuotesFile();

  /**
   * Get quotes by Security, TimeFrame and Date
   *
   * @param securityCode security isin
   * @param timeFrame    timeframe enum
   * @param dateTime     date
   * @return stream of Quotes
   */
  Flux<Quote> findBySecurityAndTimeFrameAndDateTime(String securityCode, TimeFrame timeFrame, LocalDate dateTime);
}
