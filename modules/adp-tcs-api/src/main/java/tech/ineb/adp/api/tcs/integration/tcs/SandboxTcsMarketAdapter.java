package tech.ineb.adp.api.tcs.integration.tcs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.ineb.adp.api.tcs.integration.MarketAdapter;
import tech.ineb.alpha.lib.common.tcs.model.BrokerAccountType;
import tech.ineb.alpha.lib.common.tcs.model.SandboxRegisterRequest;
import tech.ineb.alpha.lib.common.tcs.model.SandboxRegisterResponse;
import tech.ineb.lib.common.models.Quote;
import tech.ineb.lib.common.models.TimeFrame;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@Component @Profile("sandbox")
@RequiredArgsConstructor @Slf4j
public class SandboxTcsMarketAdapter implements MarketAdapter, InitializingBean {
  private final WebClient client;

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("Make registration request to TCS sandbox");
    tcsMarketService.register();


    sandbox / register —
    sandbox / currencies / balance —выставление баланса по валютным позициям
    sandbox / positions / balance —выставление баланса по не -валютным позициям
    sandbox / clean —очи

  }


  @Override
  public Flux<Quote> findBySecurityAndTimeFrameAndDateTime(String securityCode, TimeFrame timeFrame, LocalDate dateTime) {
    return null;
  }

  /**
   * Регистрация в sandbox, создание валютных позиций
   */
  private void register() {
    WebClient.RequestHeadersSpec<?> requestSpec = client
        .method(HttpMethod.POST)
        .uri(
            uriBuilder -> uriBuilder.pathSegment("/register").build()
        )
        .body(
            Mono.just(new SandboxRegisterRequest().brokerAccountType(BrokerAccountType.TINKOFF)),
            SandboxRegisterRequest.class
        );

    WebClient.ResponseSpec responseSpec = requestSpec
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .acceptCharset(StandardCharsets.UTF_8)
        .ifNoneMatch("*")
        .ifModifiedSince(ZonedDateTime.now())
        .retrieve();

    Mono<SandboxRegisterResponse> response = responseSpec.bodyToMono(SandboxRegisterResponse.class);

  }
}
