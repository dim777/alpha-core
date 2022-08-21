package tech.ineb.lib.common.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"created"})
@ToString(exclude = {"created"})
public class Order {
  private UUID id;
  private UUID extId;
  private Double volume;
  private Double price;
  private Integer amount;
  private OrderType orderType;
  private OrderStatus orderStatus;
  private LocalDateTime created;
  private Security security;
}
