package tech.ineb.adp.api.binance.strategy;

import tech.ineb.adp.api.binance.manager.MarketDataListener;
import tech.ineb.adp.api.binance.model.OrderBookDTO;

public interface Strategy extends MarketDataListener<OrderBookDTO> {
}
