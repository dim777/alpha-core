package tech.ineb.lib.common.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Security {
  private UUID id;
  private String code;
  private String name;
  private Double commission;
  private Double step;
  private Boolean active;
  private Currency currency;
}
