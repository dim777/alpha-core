package tech.ineb.lib.common.models;


import tech.ineb.lib.common.models.ex.IntervalUnitNotFoundEx;
import tech.ineb.lib.common.models.ex.OrderStatusNotFoundEx;

public enum OrderStatus {
  ORDER_ACTIVE(0, 'A'),
  ORDER_INACTIVE(1, 'I');

  private final Integer code;
  private final Character statusCode;

  OrderStatus(Integer code, Character statusCode) {
    this.code = code;
    this.statusCode = statusCode;
  }

  public Integer getCode() {
    return code;
  }

  public Character getStatusCode() {
    return statusCode;
  }

  public static OrderStatus findByCode(Character statusCode) throws IntervalUnitNotFoundEx {
    for (OrderStatus orderStatus : OrderStatus.values()) {
      if (orderStatus.getStatusCode().equals(statusCode)) return orderStatus;
    }
    throw new OrderStatusNotFoundEx("Order status=" + statusCode + " not found");
  }
}
