package ru.xegex.alpha.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.xegex.alpha.model.Quote;
import ru.xegex.alpha.model.Security;
import ru.xegex.alpha.model.Tick;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AlphaStrategy implements Strategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlphaStrategy.class);

    //private final OperationalTime opTime;
    private final Map<Security, List<Tick>> ticksCache = new ConcurrentHashMap<>();
    private final Map<Security, List<Quote>> quotesCache = new ConcurrentHashMap<>();

    @Override
    public void validateOpTime() {
        LOGGER.debug("check market open hours");
        //opTime.check();
    }

    @Override
    public Tick process(Tick tick) {
        validateOpTime();
        List<Tick> ticks = addTick2Cache(tick);
        return null;
    }

    @Scheduled(cron = "* * * ? * *")
    public void batch() {
//        strategy.validateOpTime();
//        List<Quote> quotes = quoteService.findAllUnprocessed();
//        quotes.forEach(strategy::process);
    }

    private List<Tick> addTick2Cache(Tick tick) {
        List<Tick> ticks = ticksCache.get(tick.getSecurity());
        if (ticks == null) {
            ticks = new ArrayList<>();
        }
        ticks.add(tick);
        return ticks;
    }
}
