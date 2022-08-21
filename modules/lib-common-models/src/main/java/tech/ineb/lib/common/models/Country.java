package tech.ineb.lib.common.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"stocks"})
@ToString(exclude = {"stocks"})
public class Country {
  private UUID id;
  private UUID extId;
  private Integer number;
  private Integer code;
  private String shortName;
  private String fullName;
  private String alpha2;
  private String alpha3;
  private Set<Stock> stocks = new HashSet<>();
}

