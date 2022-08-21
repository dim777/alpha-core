package tech.ineb.adp.api.binance.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration @Slf4j
public class ThreadPoolConfig {
  private static final String poolPrefix = "api-binance-";

  @Bean
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
    pool.setCorePoolSize(6);
    pool.setMaxPoolSize(12);
    pool.setQueueCapacity(120);
    pool.setThreadNamePrefix(poolPrefix);
    pool.setWaitForTasksToCompleteOnShutdown(true);

    log.info("Following Thread pool executor configured = {}", pool);

    return pool;
  }
}

