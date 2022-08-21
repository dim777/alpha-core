package tech.ineb.adp.api.tcs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@Configuration
public class MarketDataSourcesConfig {
  @Bean @ConfigurationProperties(prefix = "market.data.tcs") @Validated
  public TcsConfig tcsConfig() {
    return new TcsConfig();
  }

  @Data
  public static class TcsConfig {
    @NotEmpty
    private String url;
    @NotEmpty
    private String token;
  }
}
