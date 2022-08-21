package tech.ineb.message.broker;

public interface Producer {
  MetaInfo add(Consumer consumer);

  MetaInfo delete(Consumer consumer);

  <T> void send(T payload);
}
