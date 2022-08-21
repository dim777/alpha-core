//package ru.xegex.alpha.streams;

//@Configuration
//public class SerdesConfig {
//    private final AppConfig.KafkaConfigProperties kafkaConfigProperties;
//    private final Map<String, String> serdeConfig;
//
//
//    public SerdesConfig(AppConfig.KafkaConfigProperties kafkaConfigProperties, Map<String, String> serdeConfig) {
//        this.kafkaConfigProperties = kafkaConfigProperties;
//        this.serdeConfig = serdeConfig;
//    }
//
//    @Bean
//    public Map<String, String> serdeConfig() {
//        return Collections.singletonMap(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaConfigProperties.getSchemaRegistryUrl());
//    }
//
//    @Bean
//    public SpecificAvroSerde<postgres.als.limit.Key> limitsKeyAvroSerde() {
//        SpecificAvroSerde<postgres.als.limit.Key> limitsKeyAvroSerde = new SpecificAvroSerde<>();
//        limitsKeyAvroSerde.configure(serdeConfig, true);
//        return limitsKeyAvroSerde;
//    }
//
//    @Bean
//    public SpecificAvroSerde<postgres.als.limit.Envelope> limitsValueAvroSerde() {
//        SpecificAvroSerde<postgres.als.limit.Envelope> limitsValueAvroSerde = new SpecificAvroSerde<>();
//        limitsValueAvroSerde.configure(serdeConfig, false);
//        return limitsValueAvroSerde;
//    }
//}
