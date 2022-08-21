//package ru.xegex.alpha.streams;

//@Configuration
//public class KStreamsConfig {
//    private final AppConfig.KafkaStreamsConfigProperties streamsConfigProperties;
//    private final StreamsBuilder streamsBuilder;
//    private final SpecificAvroSerde<postgres.als.limit.Key> ticksKeyAvroSerde;
//    private final SpecificAvroSerde<postgres.als.limit.Envelope> ticksValueAvroSerde;
//
//    public KStreamsConfig(AppConfig.KafkaStreamsConfigProperties streamsConfigProperties, StreamsBuilder streamsBuilder, SpecificAvroSerde<postgres.als.limit.Key> ticksKeyAvroSerde, SpecificAvroSerde<postgres.als.limit.Envelope> ticksValueAvroSerde) {
//        this.streamsConfigProperties = streamsConfigProperties;
//        this.streamsBuilder = streamsBuilder;
//        this.ticksKeyAvroSerde = ticksKeyAvroSerde;
//        this.ticksValueAvroSerde = ticksValueAvroSerde;
//    }
//
//    @Bean
//    public KStream<postgres.als.limit.Key, postgres.als.limit.Envelope> limitsKStream() {
//        return streamsBuilder.stream(
//                streamsConfigProperties.getTicksTopic(),
//                Consumed.with(limitsKeyAvroSerde, limitsValueAvroSerde));
//    }
//}
