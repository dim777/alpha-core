package tech.ineb.ats.alpha.broker;

import tech.ineb.ats.alpha.market.message.Message;

public interface Subscriber {
    /**
     * Send message to a subscriber
     * @param message
     */
    void input(Message<?> message);
    void output(Message<?> message);
}
