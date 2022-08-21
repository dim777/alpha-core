package tech.ineb.lib.common.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Tick {
    private UUID id;
    private UUID extId;
    private Double ask;
    private Double bid;
    private Double volume;
    private LocalDateTime time;
    private Security security;
}