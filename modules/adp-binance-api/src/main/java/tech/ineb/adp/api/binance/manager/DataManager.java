package tech.ineb.adp.api.binance.manager;

public interface DataManager<T> {
  Boolean unsubscribe(String dataType, MarketDataListener<T> listener);

  Boolean notify(String dataType, T data);
}
