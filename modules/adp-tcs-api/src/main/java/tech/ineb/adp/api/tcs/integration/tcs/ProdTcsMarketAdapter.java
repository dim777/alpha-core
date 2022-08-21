package tech.ineb.adp.api.tcs.integration.tcs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tech.ineb.adp.api.tcs.integration.MarketAdapter;
import tech.ineb.adp.api.tcs.service.MarketService;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@Component @Profile("prod")
@RequiredArgsConstructor @Slf4j
public class ProdTcsMarketAdapter implements MarketAdapter {
  private final MarketService tcsMarketService;

//  @Override
//  public void afterPropertiesSet() throws Exception {
//    log.info("Make registration request to TCS sandbox");
//    tcsMarketService.register();
//  }

  @Override public String code() {
    return null;
  }
}
