package tech.ineb.ats.alpha.broker;

import org.springframework.stereotype.Service;
import tech.ineb.ats.alpha.ex.TopicEx;
import tech.ineb.ats.alpha.market.message.Message;
import tech.ineb.ats.alpha.market.message.Topic;

import java.util.*;

/**
 * Messaging services implementation
 *
 * @author dim777
 */
@Service
public class BrokerServiceImpl implements BrokerService {
    private final List<Publisher> publishers = new ArrayList<>();
    private final Map<Topic, List<Subscriber>> subscribers = new HashMap<>();

    @Override
    public void register(final Publisher publisher) {
        publishers.add(publisher);
    }

    @Override
    public void subscribe(final Topic topic, final Subscriber subscriber) {
        Optional<List<Subscriber>> subscriberOp = Optional
                .ofNullable(subscribers.get(topic));
        if (!subscriberOp.isPresent()) {
            subscribers.put(topic, new ArrayList<Subscriber>() {
                {
                    add(subscriber);
                }
            });
        }
        subscribers.get(topic).add(subscriber);
    }

    @Override
    public void broadcast(Message<?> message) {

    }

    @Override
    public void sendTo(Topic topic, Message<?> message) throws TopicEx {

    }

    /**@Override
    public void broadcast(final Message<?> message) {
        publishers.stream().forEach(p -> p.receive(message));
        subscribers.forEach((k, v) -> v.stream().forEach(s -> s.receive(message)));
    }

    @Override
    public void sendTo(final Topic topic, final Message<?> message) throws TopicEx {
        Optional<List<Subscriber>> subscriberOp = Optional
                .ofNullable(subscribers.get(topic));
        List<Subscriber> subList = subscriberOp.
                orElseThrow(() -> new TopicEx("Specified topic=" + topic + " doesn't exist"));
        subList.forEach(s -> s.receive(message));
    }**/
}
