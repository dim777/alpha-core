package tech.ineb.adp.api.binance.model;

import lombok.Getter;
import lombok.Setter;

import java.util.TreeMap;

@Getter @Setter
public class OrderBookDTO extends TreeMap<Double, Double> {
  private String id;
}
