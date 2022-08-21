package tech.ineb.adp.api.binance.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.ineb.adp.api.binance.publishers.OrderBookPublisher;

@Component @RequiredArgsConstructor @Slf4j
public class SchedulerComponent {
  private final OrderBookPublisher restOrderBookPublisher;

  @Scheduled(initialDelay = 2000, fixedRate = 60 * 60 * 1000)
  private void process() {
    Boolean isPublished = restOrderBookPublisher.publish();
    log.debug("Is publish OK = {}", isPublished);
  }
}