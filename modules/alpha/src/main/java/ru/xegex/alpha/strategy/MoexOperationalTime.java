package ru.xegex.alpha.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.xegex.alpha.ex.strategy.OpTimeEx;

import java.time.LocalDateTime;

@Component
public class MoexOperationalTime implements OperationalTime {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoexOperationalTime.class);

    @Override
    public void check() {
        LocalDateTime ldt = LocalDateTime.now();
        if (ldt.getHour() < 10) {
            throw new OpTimeEx("Moex is not open now < 10h");
        }
        if (ldt.getHour() == 10 && ldt.getMinute() <= 15) {
            throw new OpTimeEx("Wait 15 min to start Moex session");
        }
        if (ldt.getHour() == 13 && ldt.getMinute() >= 45) {
            throw new OpTimeEx("Moex 13h clearing");
        }
        if (ldt.getHour() == 18 && ldt.getMinute() >= 50) {
            throw new OpTimeEx("Moex 18h clearing");
        }
        if (ldt.getHour() == 23 && ldt.getMinute() >= 40) {
            throw new OpTimeEx("Moex is closing");
        }

    }
}
