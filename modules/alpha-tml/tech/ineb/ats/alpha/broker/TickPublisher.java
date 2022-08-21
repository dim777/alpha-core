package tech.ineb.ats.alpha.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ineb.ats.alpha.market.message.Message;

@Service
public class TickPublisher implements Publisher {
    private final BrokerService brokerService;

    @Autowired
    public TickPublisher(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @Override
    public void input(Message<?> message) {

    }

    @Override
    public void output(Message<?> message) {

    }
}
