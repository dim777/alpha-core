package ru.xegex.alpha.messaging.serde;

import org.apache.kafka.common.serialization.Serializer;
import ru.xegex.alpha.messaging.Envelope;
import ru.xegex.alpha.messaging.ex.SerDeEx;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class EnvelopeSerializer implements Serializer<Envelope<?>> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //nothing to do
    }

    @Override
    public byte[] serialize(String topic, Envelope<?> data) {
        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bytesOut)) {
            out.writeObject(data);
            return bytesOut.toByteArray();
        } catch (IOException e) {
            throw new SerDeEx("Couldn't serialize message, ex=" + e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        //nothing to do
    }
}
