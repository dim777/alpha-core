package tech.ineb.adp.api.binance.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MarketPropertiesConfig {

  @Bean @Validated @ConfigurationProperties(prefix = "market")
  public MarketProperties marketProperties() {
    return new MarketProperties();
  }

  @Data
  public static class MarketProperties {
    private List<Security> securities = new ArrayList<>();

    @Getter @Setter
    public static class Security {
      private String name;
      private String base;
      private List<String> codes;
    }
  }
}
