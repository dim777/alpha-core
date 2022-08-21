package tech.ineb.adp.api.tcs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ineb.adp.api.tcs.integration.MarketAdapter;

@Service @Slf4j @RequiredArgsConstructor
public class BaseQuotesService implements QuotesService {
  private final MarketAdapter marketAdapter;

  @Override public String getQuotesFile() {
    marketAdapter.getQuotes
    return null;
  }
}
