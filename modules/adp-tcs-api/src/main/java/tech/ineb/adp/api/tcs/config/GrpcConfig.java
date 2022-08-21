package tech.ineb.adp.api.tcs.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration @Slf4j
public class GrpcConfig {
  @Bean Server grpcServer() throws IOException, InterruptedException {
    Server grpcServer = ServerBuilder
        .forPort(8080)
        .addService(new HelloServiceImpl()).build();
    log.info("Start Grpc server = '{}'", grpcServer);
    grpcServer.start();
    return grpcServer;
  }

  @PreDestroy
  public void terminate(Server grpcServer) throws InterruptedException {
    log.info("Wait grpc server to terminate ...");
    grpcServer.awaitTermination();
  }
}
