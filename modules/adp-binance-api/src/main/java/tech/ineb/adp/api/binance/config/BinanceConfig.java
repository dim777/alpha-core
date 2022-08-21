package tech.ineb.adp.api.binance.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Configuration @Slf4j
public class BinanceConfig {
  @Bean @Validated @ConfigurationProperties(prefix = "market.data.binance")
  public BinanceApiConfig binanceApiConfig() {
    return new BinanceApiConfig();
  }

  @Data
  public static class BinanceApiConfig {
    @NotEmpty
    private String api;
    @NotEmpty
    private String url;
  }
}
