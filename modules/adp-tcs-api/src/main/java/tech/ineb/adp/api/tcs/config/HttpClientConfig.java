package tech.ineb.adp.api.tcs.config;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@Configuration @ConfigurationProperties(prefix = "http")
@Getter @Setter @Slf4j
public class HttpClientConfig {

  /**
   * Set default value for connection timeout
   *
   * @see org.springframework.http.client.HttpComponentsClientHttpRequestFactory#setConnectTimeout(int)
   */
  @NotNull
  @PositiveOrZero
  @Builder.Default
  private Integer connectTimeout = 30000;

  /**
   * Set default value for read timeout
   *
   * @see org.springframework.http.client.HttpComponentsClientHttpRequestFactory#setConnectTimeout(int)
   */
  @NotNull
  @PositiveOrZero
  @Builder.Default
  private Integer readTimeout = 30000;
}