package tech.ineb.adp.api.binance.service;

import tech.ineb.alpha.adp.binance.model.InlineResponse2002;

public interface RestApiService {
  InlineResponse2002 getMarketDepth(String security);
}
