package tech.ineb.adp.api.binance.strategy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tech.ineb.adp.api.binance.model.OrderBookDTO;

import java.util.Map;

@Component @Scope("prototype")
@AllArgsConstructor @Slf4j
public class PairStrategy implements Strategy {
  private final Map<String, OrderBookDTO> orderBookRegistry;

  @Override public void update(String dataType, OrderBookDTO data) {
    log.debug("DataType = {}", dataType);
  }
}
