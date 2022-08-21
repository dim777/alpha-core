package ru.xegex.alpha.messaging.serde;

import org.apache.kafka.common.serialization.Deserializer;
import ru.xegex.alpha.messaging.Envelope;
import ru.xegex.alpha.messaging.ex.SerDeEx;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class EnvelopeDeserializer implements Deserializer<Envelope<?>> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //nothing to do
    }

    @Override
    public Envelope<?> deserialize(String topic, byte[] data) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (Envelope<?>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new SerDeEx("Couldn't deserialize envelope message, ex=" + e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        //nothing to do
    }
}
