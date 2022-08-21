package tech.ineb.svc.data.api.config;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration @RequiredArgsConstructor @Slf4j
public class DSLConfig {
  private final ConnectionFactory factory;

  @Bean
  public DSLContext dsl() {
    DSLContext dsl = DSL.using(factory).dsl();
    log.info("Initialized DSL = {}", dsl);
    return dsl;
  }
}
