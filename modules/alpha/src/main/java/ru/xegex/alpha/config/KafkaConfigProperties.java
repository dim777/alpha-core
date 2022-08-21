package ru.xegex.alpha.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.kafka")
@Getter
@Setter
public class KafkaConfigProperties {
    private String applicationId;
    private String bootstrapServers;
    private Integer cacheMaxBytesBuffering;
    private Integer commitIntervalMs;
    private Integer metadataMaxAge;
    private String autoOffsetReset;
    private String schemaRegistryUrl;
    private String restEndpointHostname;
    private Integer restEndpointPort;
    private String stateDir;
}
