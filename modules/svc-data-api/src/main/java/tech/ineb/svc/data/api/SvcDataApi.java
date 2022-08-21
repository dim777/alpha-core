package tech.ineb.svc.data.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@Slf4j @SpringBootApplication
public class SvcDataApi {
  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SvcDataApi.class, args);
    log.info("Application {} is loaded in {}.", ctx.getApplicationName(), LocalDateTime.now());
  }
}