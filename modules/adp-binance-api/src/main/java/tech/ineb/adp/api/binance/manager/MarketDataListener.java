package tech.ineb.adp.api.binance.manager;

//fixme: should be done for different market data
public interface MarketDataListener<T> {
  void update(String dataType, T data);
}
