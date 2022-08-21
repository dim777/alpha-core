package tech.ineb.lib.common.models;


import tech.ineb.lib.common.models.ex.IntervalUnitNotFoundEx;
import tech.ineb.lib.common.models.ex.OrderTypeNotFoundEx;

public enum OrderType {
  //Рыночный ордер на покупку
  ORDER_TYPE_BUY(0, 'B'),
  //Рыночный ордер на продажу
  ORDER_TYPE_SELL(1, 'S'),
  //Отложенный ордер Buy Limit
  ORDER_TYPE_BUY_LIMIT(2, 'L'),
  //Отложенный ордер Sell Limit
  ORDER_TYPE_SELL_LIMIT(3, 'M'),
  //Отложенный ордер Buy Stop
  ORDER_TYPE_BUY_STOP(4, 'T'),
  //Отложенный ордер Sell Stop
  ORDER_TYPE_SELL_STOP(5, 'F'),
  //По достижении цены ордера выставляется отложенный ордер Buy Limit по цене StopLimit
  ORDER_TYPE_BUY_STOP_LIMIT(6, 'G'),
  //По достижении цены ордера выставляется отложенный ордер Sell Limit по цене StopLimit
  ORDER_TYPE_SELL_STOP_LIMIT(7, 'H'),
  //Ордер на закрытие позиции встречной позицией
  ORDER_TYPE_CLOSE_BY(8, 'K');

  private final Integer code;
  private final Character orderType;

  OrderType(Integer code, Character orderType) {
    this.code = code;
    this.orderType = orderType;
  }

  public Integer getCode() {
    return code;
  }

  public Character getOrderType() {
    return orderType;
  }

  public static OrderType findByCode(Character orderType) throws IntervalUnitNotFoundEx {
    for (OrderType orderStatus : OrderType.values()) {
      if (orderStatus.getOrderType().equals(orderType)) return orderStatus;
    }
    throw new OrderTypeNotFoundEx("Order type=" + orderType + " not found");
  }
}
