package tech.ineb.ats.alpha.market.quote;

import tech.ineb.ats.alpha.ex.market.MarketDataEx;
import tech.ineb.ats.alpha.market.security.Equity;

import java.util.UUID;

public abstract class Quote<S extends Equity> {
    public UUID id() {
        throw new MarketDataEx();
    }

    public Double open() {
        throw new MarketDataEx();
    }

    public Double high() {
        throw new MarketDataEx();
    }

    public Double low() {
        throw new MarketDataEx();
    }

    public Double close() {
        throw new MarketDataEx();
    }

    public S security() {
        throw new MarketDataEx();
    }
}
