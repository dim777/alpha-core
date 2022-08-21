package ru.xegex.alpha.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.streams")
@Getter
@Setter
public class KafkaStreamsConfigProperties {
    private String ticksTopic;
}