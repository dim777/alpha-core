package ru.xegex.alpha;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class AlphaApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlphaApplication.class);


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AlphaApplication.class, args);

        Properties streamsConfiguration = (Properties) ctx.getBean("streamsConfiguration");
        StreamsBuilder streamsBuilder = (StreamsBuilder) ctx.getBean("streamsBuilder");
        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), streamsConfiguration);

        streams.cleanUp();
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                streams.close();
            } catch (Exception e) {
                LOGGER.error("Error while closing streams");
            }
        }));

    }

}

