package ru.xegex.strategy.starter.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This ...
 * <p></p>
 *
 * @author Dmitriy Erokhin <a href="mailto:de@ineb.ru">de@ineb.ru</a>
 **/
@Getter
@Setter
public class Quote {
    private UUID id;
    private Security security;
    private LocalDateTime dateTime;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Integer volume;
}
