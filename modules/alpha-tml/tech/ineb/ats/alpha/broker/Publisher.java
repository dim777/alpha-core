package tech.ineb.ats.alpha.broker;

import tech.ineb.ats.alpha.market.message.Message;

public interface Publisher {
    /**
     * Send message to a publisher
     * @param message
     */
    void input(Message<?> message);
    void output(Message<?> message);
}
