package tech.ineb.ats.alpha.market.pair;

import tech.ineb.ats.alpha.market.security.Equity;

public class MQuote implements Quote<Double, Equity> {
    @Override
    public Double open() {
        return null;
    }

    @Override
    public void open(Double data) {

    }

    @Override
    public Equity security() {
        return null;
    }
}
