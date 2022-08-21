package tech.ineb.adp.api.binance.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@EnableScheduling @Configuration
@RequiredArgsConstructor @Slf4j
public class AppConfig {
  @Bean
  public RestTemplate restTemplate() {
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setConnectTimeout(10000);
    requestFactory.setReadTimeout(30000);

    RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(requestFactory));
    log.info("Initialized following restTemplate = {}", restTemplate);
    return restTemplate;
  }
}
