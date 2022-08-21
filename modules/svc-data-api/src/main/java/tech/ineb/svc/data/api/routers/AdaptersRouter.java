package tech.ineb.svc.data.api.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;
import tech.ineb.svc.data.api.handlers.AdaptersTaskHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
public class AdaptersRouter {
  @Bean
  public RouterFunction<ServerResponse> doTaskByAdapter(AdaptersTaskHandler taskHandler) {
    RouterFunction<ServerResponse> route = route()
        .path("/api/v1/adapter", builder -> builder
            .POST(accept(APPLICATION_JSON), taskHandler::doTask)
            .GET(accept(APPLICATION_JSON), handler::listPeople)
            .POST("/person", handler::createPerson))
        .build();

    route()
        .GET("/person/{id}", accept(APPLICATION_JSON), handler::getPerson)
        .GET("/person", accept(APPLICATION_JSON), handler::listPeople)

    return route(
        GET("/api/v1/adapter/{code}")
            .and(accept(APPLICATION_JSON)), new HandlerFunction<ServerResponse>() {
          @Override public Mono<ServerResponse> handle(ServerRequest request) {
            return null;
          }
        });
  }
}
