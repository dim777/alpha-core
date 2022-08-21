package tech.ineb.adp.api.tcs.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Configuration @Slf4j
public class WebClientConfig {
  @Bean public WebClient tcsClient(TcsConfig tcsConfig, HttpClientConfig httpConfig) {
    HttpClient httpClient = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, httpConfig.getConnectTimeout())
        .doOnConnected(conn -> conn
            .addHandler(new ReadTimeoutHandler(httpConfig.getReadTimeout(), TimeUnit.MILLISECONDS))
        );

    WebClient client = WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(httpClient))
        .baseUrl(tcsConfig.getUrl())
        .defaultHeader("Authorization", "Bearer " + tcsConfig.getToken())
        .defaultUriVariables(Collections.singletonMap("url", tcsConfig.getUrl()))
        .build();
    log.info("Initialized following web client = {}", client);
    return client;
  }
}
