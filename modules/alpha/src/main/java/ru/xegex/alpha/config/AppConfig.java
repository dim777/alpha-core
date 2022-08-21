package ru.xegex.alpha.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class AppConfig {

    private final KafkaConfigProperties kafkaConfigProperties;

    public AppConfig(KafkaConfigProperties kafkaConfigProperties) {
        this.kafkaConfigProperties = kafkaConfigProperties;
    }

    @Bean
    public Properties streamsConfiguration() {
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaConfigProperties.getApplicationId());
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigProperties.getBootstrapServers());
        streamsConfiguration.put(StreamsConfig.APPLICATION_SERVER_CONFIG, kafkaConfigProperties.getRestEndpointHostname() + ":" + kafkaConfigProperties.getRestEndpointPort());
        streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG, kafkaConfigProperties.getStateDir());
        streamsConfiguration.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, kafkaConfigProperties.getCacheMaxBytesBuffering());
        streamsConfiguration.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, kafkaConfigProperties.getCommitIntervalMs());
        streamsConfiguration.put(CommonClientConfigs.METADATA_MAX_AGE_CONFIG, kafkaConfigProperties.getMetadataMaxAge());
        streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaConfigProperties.getAutoOffsetReset());
        return streamsConfiguration;
    }

    @Bean
    public StreamsBuilder streamsBuilder() {
        return new StreamsBuilder();
    }
}
