package tech.ineb.adp.api.binance.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tech.ineb.adp.api.binance.config.BinanceConfig;
import tech.ineb.alpha.adp.binance.model.InlineResponse2002;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service @Slf4j
public class BinanceRestApiService implements RestApiService {
  private final BinanceConfig.BinanceApiConfig binanceApiConfig;
  private final RestTemplate restTemplate;

  @Override
  //todo switch to common interface
  public InlineResponse2002 getMarketDepth(String security) {
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<?> entity = new HttpEntity<>(headers);

    String urlTemplate = UriComponentsBuilder
        .fromHttpUrl(binanceApiConfig.getUrl() + "/api/v3/depth")
        .queryParam("symbol", "{symbol}")
        .encode()
        .toUriString();

    Map<String, Object> params = new HashMap<>();
    params.put("symbol", security);

    HttpEntity<InlineResponse2002> responseEntity = restTemplate.exchange(
        urlTemplate,
        HttpMethod.GET,
        entity,
        InlineResponse2002.class,
        params
    );
    log.debug("Received following answer from Binance = {}", responseEntity);

    return responseEntity.getBody();
  }

  //fixme:
  public void sample(){
//    MultiValueMap<String, String> headers = new HttpHeaders();
//    headers.add("Authorization", binanceApiConfig.getApi());
//    headers.add("Content-Type", APPLICATION_JSON.getMimeType());
//
//    HttpEntity<ExtRequest> request = new HttpEntity<>(extRequest, headers);
//
//    ResponseEntity<ExtResponse> responseEntity = restTemplate.exchange(
//        ddConfig.getUrl() + SUGGESTIONS_API_4_1_RS_SUGGEST_PARTY,
//        HttpMethod.POST,
//        request,
//        ExtResponse.class);
//
//    log.debug("Get following response = '{}'", responseEntity);
//
//    @SuppressWarnings("unchecked")
//    ExtResponse<Organization> body = responseEntity.getBody();
//
//    if (Objects.isNull(body)) {
//      return processNext(envelope);
//    }
//
//    List<Customer> customers = body.getSuggestions().stream()
//        .map(s -> OBJECT_MAPPER.convertValue(s.getData(), Organization.class))
//        .filter(o -> Objects.isNull(o.getState().getLiquidationDate()))
//        .map(mapper::toDTO)
//        .collect(Collectors.toList());
  }
}
