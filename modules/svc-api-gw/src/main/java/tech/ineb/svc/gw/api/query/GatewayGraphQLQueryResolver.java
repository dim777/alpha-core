package tech.ineb.svc.gw.api.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component @Slf4j
public class GatewayGraphQLQueryResolver implements GraphQLQueryResolver {

  public Mono<String> hello() {
    return Mono.just("Hello world");
  }
}