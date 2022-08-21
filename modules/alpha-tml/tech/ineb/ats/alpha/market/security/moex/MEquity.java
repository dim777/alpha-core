package tech.ineb.ats.alpha.market.security.moex;

import tech.ineb.ats.alpha.market.security.Equity;
import tech.ineb.ats.alpha.market.stock.moex.MStock;

import java.util.UUID;

public class MEquity implements Equity<MStock> {
    private UUID id;
    private String name;
    private Double commission;
    private Double step;
    private Boolean active;

    @Override
    public String symbol() {
        return null;
    }

    @Override
    public void symbol(String name) {

    }

    @Override
    public MStock stock() {
        return null;
    }
}
