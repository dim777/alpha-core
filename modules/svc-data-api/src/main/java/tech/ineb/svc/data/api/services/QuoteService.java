package tech.ineb.svc.data.api.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.ineb.lib.common.models.Quote;

public interface QuoteService {
  Mono<Void> save(Flux<Quote> quotes);
  findById();
}
