package tech.ineb.lib.common.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Stock {
  private UUID id;
  private UUID extId;
  private String name;
  private Security security;
  private Country country;
}
