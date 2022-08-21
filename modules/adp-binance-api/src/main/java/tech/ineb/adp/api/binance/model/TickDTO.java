package tech.ineb.adp.api.binance.model;

import lombok.Data;

@Data
public class TickDTO {
  private String security;
  private Double ask;
  private Double bid;
}
