package tech.ineb.ats.alpha.strategy;

//import tech.ineb.ats.alpha.market.MarketData;
//import tech.ineb.ats.alpha.market.tick.BTick;

public class PairStrategyTests {
//    private static final Logger LOGGER = LoggerFactory.getLogger(PairStrategyTests.class);
//
//    private static Tick tick0 = new BTick(13.10, 13.05);
//    private static Tick tick1 = new BTick(120.0010, 120.0005);
//
//    @Test
//    public void testStrategiesPortfolioTick() {
//        final ExecutorService pool = Executors.newFixedThreadPool(5);
//
//        AStrategy<Tick, Double> strategy0 = new PairStrategy<>(pool, "strategy0");
//        AStrategy<Tick, Double> strategy1 = new PairStrategy<>(pool, "strategy1");
//        AStrategy<Tick, Double> strategy2 = new PairStrategy<>(pool, "strategy2");
//
//        DataFabric<Observer<Tick>, Tick> dataFabric = new BDataFabric<>();
//        dataFabric.register(strategy0);
//        dataFabric.register(strategy1);
//        dataFabric.register(strategy2);
//
//        dataFabric.push(tick0);
//        dataFabric.push(tick1);
//
//        Assert.assertEquals(0.02, strategy0.getResult(), 0.001);
//        Assert.assertEquals(0.02, strategy1.getResult(), 0.001);
//        Assert.assertEquals(0.02, strategy2.getResult(), 0.001);
//    }
//
//    @Test
//    public void testStrategiesPortfolioTickList() {
//    }
//
//    abstract class AStrategy<T extends MarketData, R extends Number> implements Strategy<T, R>, Observer<T> {
//
//    }
//
//    class PairStrategy<T extends MarketData> extends AStrategy<T, Double> implements Callable<Double> {
//        private final ExecutorService pool;
//
//        private String sName;
//        private Double result = 0.0;
//
//        public PairStrategy(final ExecutorService pool, String sName) {
//            this.pool = pool;
//            this.sName = sName;
//        }
//
//        @Override
//        public String getName() {
//            return sName;
//        }
//
//        @Override
//        public String getDescription() {
//            return null;
//        }
//
//        @Override
//        public String[] getSecurities() {
//            return new String[0];
//        }
//
//        @Override
//        public void pre(Pair<T, T> pair) {
//
//        }
//
//        @Override
//        public Double getResult() {
//            return result;
//        }
//
//        @Override
//        public void update(T data) {
//            LOGGER.info("PairStrategy get trade={}", data);
//            Callable<Double> processor = this::call;
//            Double result = process(processor);
//        }
//
//        private Double process(Callable<Double> processor) {
//            Future<Double> resultFuture = pool.submit(processor);
//            Double result = null;
//            try {
//                result = resultFuture.get();
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//            if (result == null) throw new StrategyEx("Result could not be null");
//            return result;
//        }
//
//        @Override
//        public void updateAll(List<T> data) {
//            data.forEach(this::update);
//        }
//
//        @Override
//        public Double call() throws Exception {
//            LOGGER.info("PairStrategy get trade={}");
//            addResult();
//            return result;
//        }
//
//        private synchronized void addResult() {
//            result += 0.01;
//        }
//    }
}
