package tech.ineb.ats.alpha.market.tick;

import lombok.Data;
import tech.ineb.ats.alpha.market.security.Equity;

import java.time.LocalDateTime;

public interface Tick {
    Double ask();

    Double bid();

    @Data
    class BTick<S extends Equity> implements Tick {
        private Double ask;
        private Double bid;
        private LocalDateTime creation;
        private LocalDateTime received;
        private Integer volume;

        @Override
        public Double ask() {
            return null;
        }

        @Override
        public Double bid() {
            return null;
        }
    }
}