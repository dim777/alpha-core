package tech.ineb.adp.api.tcs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@SpringBootApplication
@Slf4j
public class SvcMarketOrchestratorApi {
  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SvcMarketOrchestratorApi.class, args);
    log.info("Application {} is loaded in {}.", ctx.getApplicationName(), LocalDateTime.now());
  }
}