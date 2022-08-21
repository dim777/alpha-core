package tech.ineb.adp.api.binance.publishers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import tech.ineb.adp.api.binance.config.MarketPropertiesConfig;
import tech.ineb.adp.api.binance.manager.DataManager;
import tech.ineb.adp.api.binance.mapping.OrderBookMapping;
import tech.ineb.adp.api.binance.model.OrderBookDTO;
import tech.ineb.adp.api.binance.service.RestApiService;
import tech.ineb.alpha.adp.binance.model.InlineResponse2002;

@Service
@AllArgsConstructor @Slf4j
public class RestOrderBookPublisher implements OrderBookPublisher {
  private final RestApiService restApiService;
  private final OrderBookMapping mapper;
  private final ThreadPoolTaskExecutor taskExecutor;
  private final MarketPropertiesConfig marketPropertiesConfig;
  private final DataManager<OrderBookDTO> dataManager;

  @Override public Boolean publish() {
    marketPropertiesConfig.marketProperties()
        .getSecurities()
        .stream()
        .flatMap(security -> security.getCodes()
            .stream())
        .map(s -> s.replaceAll("\\|", ""))
        .forEach(s -> {
          Runnable r = () -> {
            InlineResponse2002 marketDepth = restApiService.getMarketDepth(s);
            log.debug("Get following order book for security s = {}", s);
            OrderBookDTO orderBookDTO = mapper.toDTO(marketDepth);
            dataManager.notify("OrderBook", orderBookDTO);
          };
          taskExecutor.execute(r);
        });
    return Boolean.TRUE;
  }
}
