package tech.ineb.svc.gw.api.config;

import liquibase.integration.spring.SpringLiquibase;
import org.jooq.DSLContext;
import org.jooq.tools.jdbc.SingleConnectionDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class LiquibaseConfig {
  @Bean @Profile("!local-test") @Primary
  @ConfigurationProperties(prefix = "spring.liquibase")
  public SpringLiquibase liquibase(DSLContext dsl) {
    SingleConnectionDataSource dataSource =
        new SingleConnectionDataSource(dsl.diagnosticsConnection());

    SpringLiquibase springLiquibase = new SpringLiquibase();
    springLiquibase.setDataSource(dataSource);
    return springLiquibase;
  }
}
