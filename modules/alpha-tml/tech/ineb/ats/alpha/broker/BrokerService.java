package tech.ineb.ats.alpha.broker;

import tech.ineb.ats.alpha.ex.TopicEx;
import tech.ineb.ats.alpha.market.message.Message;
import tech.ineb.ats.alpha.market.message.Topic;

/**
 * Messaginf interface
 *
 * @author dim777
 */
public interface BrokerService {
    void register(Publisher publisher);

    void subscribe(final Topic topic, final Subscriber subscriber);

    /**
     * Send to all topics
     *
     * @param message
     */
    void broadcast(Message<?> message);

    void sendTo(Topic topic, Message<?> message) throws TopicEx;
}
