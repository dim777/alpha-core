package tech.ineb.svc.data.api.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j @Configuration
@ComponentScan(basePackages = {"tech.ineb.svc.imprt.data"})
public class AppConfig {
  @Data
  public static class TcsConfig {
    @NotEmpty
    private String url;
    @NotNull
    @PositiveOrZero
    private Integer connectTimeout = 10_000;
    @NotNull
    @PositiveOrZero
    private Integer readTimeout = 10_000;
    @NotNull
    @PositiveOrZero
    private Integer timeout = 10_000;
  }

  @Bean
  public TcsConfig tcsConfig() {
    return new TcsConfig();
  }

  @Bean
  public RestTemplate stravaRestTemplate(TcsConfig tcsConfig) {
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setConnectTimeout(tcsConfig.getConnectTimeout());
    requestFactory.setReadTimeout(tcsConfig.getReadTimeout());

    RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(requestFactory));
    restTemplate.setInterceptors(Collections.singletonList(this::interceptor));
    return restTemplate;
  }

  @Bean
  public ExecutorService executor() {
    return Executors.newSingleThreadExecutor();
  }
}
