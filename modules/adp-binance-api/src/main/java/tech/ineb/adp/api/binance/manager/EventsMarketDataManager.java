package tech.ineb.adp.api.binance.manager;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.ineb.adp.api.binance.model.OrderBookDTO;

import java.util.Set;

@Component
@AllArgsConstructor @Slf4j
public class EventsMarketDataManager implements DataManager<OrderBookDTO> {
  private final Set<MarketDataListener<OrderBookDTO>> listeners;

  @Override public Boolean unsubscribe(String dataType, MarketDataListener<OrderBookDTO> listener) {
    throw new RuntimeException("Not implemented yet");
  }

  @Override public Boolean notify(String dataType, OrderBookDTO data) {
    listeners
        .forEach(l -> l.update("OrderBook", data));
    log.debug("Send orderBook update to listeners");
    return Boolean.TRUE;
  }
}
