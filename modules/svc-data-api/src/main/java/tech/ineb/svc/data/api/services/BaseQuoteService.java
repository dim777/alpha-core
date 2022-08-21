package tech.ineb.svc.data.api.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.ineb.lib.common.models.Quote;

@Service @Slf4j @RequiredArgsConstructor
public class BaseQuoteService implements QuoteService {
  private final DatabaseClient databaseClient;

  @Transactional @Override
  public Mono<Void> save(Flux<Quote> quotes) {
    Mono<Void> r = databaseClient
        .sql("INSERT INTO person (name, age) VALUES('Joe', 34)")
        .fetch().rowsUpdated()
        .then(databaseClient
            .sql("INSERT INTO contacts (name) VALUES('Joe')")
            .then());
    return r;
  }

  public
  Mono.from(connectionFactory.create())
      .flatMapMany(connection -> connection
      .createStatement("SELECT firstname FROM PERSON WHERE age > $1")
      .bind("$1", 42)
    .execute())
      .flatMap(result -> result
      .map((row, rowMetadata) -> row.get("firstname", String.class)))
      .doOnNext(System.out::println)
  .subscribe();
}
