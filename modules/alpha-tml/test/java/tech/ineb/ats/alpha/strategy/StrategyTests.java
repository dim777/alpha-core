package tech.ineb.ats.alpha.strategy;

import org.junit.Test;
import tech.ineb.ats.alpha.market.tick.Tick;

import java.util.function.Function;

public class StrategyTests {
//    private static Tick fTick0 = new BTick(13.10, 13.05);
//    private static Tick sTick0 = new BTick(120.0010, 120.0005);
//
//    /**
//     * GAZP,0,20180917,095938,151.990000000,10
//     */
//    @Test
//    public void testMarkovitzForDifferentData() {
//        ClassInfoList classInfos = ReflectionsHelper.findClassesAnnotatedWith(tech.ineb.ats.alpha.annotations.Strategy.class);
//        classInfos.forEach(c -> {
//            Object r = ReflectionsHelper.loadStrategyClass(c);
//
//            Strategy<Tick, Double> strategy = (Strategy<Tick, Double>) Proxy.newProxyInstance(
//                    Strategy.class.getClassLoader(),
//                    new Class<?>[]{Strategy.class},
//                    new StrategyProxy(Pair.of(r, c)));
//
//            //rules.add(proxyInstance.getName());
//            strategy.pre(Pair.of(fTick0, sTick0));
//        });
//    }

    interface Strategy<T> {
        void receive(T marketData);
    }

    abstract class PositionsHandler<T> {
        private PositionsHandler<T> next;


        public PositionsHandler addNext(PositionsHandler next) {
            this.next = next;
            return next;
        }

        public abstract boolean process(Function<T, T> processor);

        protected boolean processNext(T tick) {
            if (next == null) {
                return true;
            }
            return next.process(tick);
        }
    }


    class OpenPositions extends PositionsHandler<Tick> {

        @Override
        public boolean process(Function<Tick, Tick> processor) {
            processor.apply()
            return processNext(tick);
        }
    }

    class ModifyPositions extends PositionsHandler<Tick> {

        @Override
        public boolean process(Tick tick) {
            return processNext(tick);
        }
    }

    class ClosePositions extends PositionsHandler<Tick> {

        @Override
        public boolean process(Tick tick) {
            return processNext(tick);
        }
    }

    class CointegrationStrategy implements Strategy<Tick> {
        private final PositionsHandler<Tick> positionsHandler;

        public CointegrationStrategy(PositionsHandler<Tick> positionsHandler) {
            this.positionsHandler = positionsHandler;
        }

        @Override
        public void receive(Tick marketData) {
            positionsHandler.process(marketData);
        }


    }

    @Test
    public void backTestCointegrationStrategy() {
        PositionsHandler<Tick> openPositionsHandler = new OpenPositions();
        PositionsHandler<Tick> modifyPositionsHandler = new ModifyPositions();
        PositionsHandler<Tick> closePositionsHandler = new ClosePositions();

        openPositionsHandler.addNext(modifyPositionsHandler.addNext(closePositionsHandler));

        Strategy cointegrationStrategy = new CointegrationStrategy(openPositionsHandler);


    }
}
