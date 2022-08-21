package tech.ineb.ats.alpha.market.security;

import tech.ineb.ats.alpha.market.stock.Stock;

public interface Equity<S extends Stock> {
    String symbol();

    void symbol(String name);

    S stock();
}
