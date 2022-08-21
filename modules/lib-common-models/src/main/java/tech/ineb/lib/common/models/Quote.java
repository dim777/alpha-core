package tech.ineb.lib.common.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Quote {
  private UUID id;
  private Double open;
  private Double high;
  private Double low;
  private Double close;
  private LocalDateTime time;
  private TimeFrame timeFrame;
  private Security security;
}
