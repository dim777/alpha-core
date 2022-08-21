package tech.ineb.ats.alpha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import tech.ineb.ats.alpha.broker.BrokerService;
import tech.ineb.ats.alpha.config.AppConfig;
import tech.ineb.ats.alpha.config.dev.H2Config;
import tech.ineb.ats.alpha.market.quote.BQuote;
import tech.ineb.ats.alpha.market.quote.Quote;
import tech.ineb.ats.alpha.market.security.Equity;
import tech.ineb.ats.alpha.market.stock.Stock;
import tech.ineb.ats.alpha.market.stock.moex.MStock;
import tech.ineb.ats.alpha.market.tick.Tick;
import tech.ineb.ats.alpha.repository.QuoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        AppConfig.class,
        H2Config.class})
@ActiveProfiles(value = {"dev"})
public class AlphaApplicationTests {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private BrokerService messagingService;
    @Autowired
    private ModelMapper mapper;

    /**
     * @Test public void whenNewPublisher_thenRegisterIt() {
     * Publisher publisher = new TickPublisher();
     * messagingService.register();
     * <p>
     * }
     * @Test public void whenNewSubscriber_thenSubscribeToSpecificTopic(){
     * messagingService.subscribe(final Topic topic, final Subscriber subscriber);
     * }
     * @Test public void broadcatToAllPubsAndSubs(){
     * messagingService.broadcast(Message<?> message);
     * }
     * @Test public void whenNewMessage_thenSubscribeToSpecificTopic(){
     * messagingService.sendTo(Topic topic, Message<?> message) throws TopicEx;
     * }
     **/

    @Test
    public void initialTest() {
        Stock moexStock = new MStock();


        quoteRepository.findAllStream().map(q -> {
            Quote<Equity> quote = mapper.map(q, BQuote.class);
            return quote;
        });

        Tick.BTick<Equity> sdsd = new Tick.BTick<>();

        //Quote<Equity> quote = BQuote.of().setId();
    }
}
