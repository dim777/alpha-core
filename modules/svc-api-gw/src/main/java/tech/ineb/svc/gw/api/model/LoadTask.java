package tech.ineb.svc.gw.api.model;

import lombok.Data;
import tech.ineb.lib.common.models.Security;
import tech.ineb.lib.common.models.TimeFrame;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class LoadTask {
  private UUID id;
  private Security security;
  private TimeFrame timeFrame;
  private LocalDateTime dateTime;
}
