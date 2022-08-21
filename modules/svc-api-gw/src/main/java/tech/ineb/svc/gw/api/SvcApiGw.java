package tech.ineb.svc.gw.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication @Slf4j
public class SvcApiGw {
  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SvcApiGw.class, args);
    log.info("Application {} is loaded in {}.", ctx.getId(), LocalDateTime.now());
  }
}
