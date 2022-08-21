package tech.ineb.ats.alpha.market.stock.moex;

import tech.ineb.ats.alpha.market.stock.Stock;

/**
 * Moex stock exchange
 */
public class MStock implements Stock {
    private static final Country COUNTRY = new Stock.Country();

    static {
        COUNTRY.setCode(0);
        COUNTRY.setName("RUSSIA");
    }

    private String stockName;

    @Override
    public String name() {
        return stockName;
    }

    @Override
    public Country country() {
        return COUNTRY;
    }
}
