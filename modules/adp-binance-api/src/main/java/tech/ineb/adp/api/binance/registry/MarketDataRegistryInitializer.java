package tech.ineb.adp.api.binance.registry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.ineb.adp.api.binance.config.MarketPropertiesConfig;
import tech.ineb.adp.api.binance.model.OrderBookDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration @Slf4j
public class MarketDataRegistryInitializer {
  @Bean
  public Map<String, OrderBookDTO> orderBookRegistry(final MarketPropertiesConfig marketPropertiesConfig) {
    List<MarketPropertiesConfig.MarketProperties.Security> securities =
        marketPropertiesConfig.marketProperties().getSecurities();

    final Map<String, OrderBookDTO> registry = new ConcurrentHashMap<>();

    //fixme: should be done without naive collection
    securities.stream()
        .flatMap(security -> security.getCodes().stream())
        .flatMap(s -> Arrays.stream(s.split("\\|")))
        .forEach(s -> registry.put(s, new OrderBookDTO()));

    log.info("Initialized new orderBook registry");
    return registry;
  }
}
