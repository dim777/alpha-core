package tech.ineb.adp.api.binance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication @Slf4j
public class AppBinanceAdapter {
  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(AppBinanceAdapter.class, args);
    log.info("Application {} is loaded in {}.", ctx.getApplicationName(), LocalDateTime.now());
  }
}