package tech.ineb.ats.alpha.strategy;

import tech.ineb.ats.alpha.annotations.*;
import tech.ineb.ats.alpha.annotations.Strategy;
import tech.ineb.ats.alpha.market.tick.Tick;
import tech.ineb.ats.alpha.utils.Pair;

@Strategy(name = "MarkovitzStrategy",
        description = "Markovitz portfolio strategy implementation",
        securities = {"LKOH", "SBRF"})
public class MarkovitzStrategy {
    private Pair<Tick, Tick> previousPairTick;
    private Pair<Tick, Tick> newPairTick;

    @tech.ineb.ats.alpha.annotations.Result
    private Result result;

    @Pre
    public void pre(final Pair<Tick, Tick> pairTick) {
        newPairTick = pairTick;
    }

    @OpenPosition
    public void openPosition() {

    }

    @ModifyPosition
    public void modifyPosition() {

    }

    @ClosePosition
    public void closePosition() {

    }

    @Post
    public void post() {
        previousPairTick = newPairTick;
    }
}
