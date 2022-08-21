package tech.ineb.message.broker;

import java.util.Set;

public interface Broker {
  Set<Consumer> consumers();

  Set<Producer> producers();

  MetaInfo publish(Producer producer);

  MetaInfo subscribe(Consumer consumer);
}
