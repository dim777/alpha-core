/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Ticks implements Serializable {

    private static final long serialVersionUID = -1284837341;

    private UUID          id;
    private BigDecimal    ask;
    private BigDecimal    bid;
    private Long          volume;
    private LocalDateTime time;
    private Integer       version;
    private UUID          equityId;

    public Ticks() {}

    public Ticks(Ticks value) {
        this.id = value.id;
        this.ask = value.ask;
        this.bid = value.bid;
        this.volume = value.volume;
        this.time = value.time;
        this.version = value.version;
        this.equityId = value.equityId;
    }

    public Ticks(
        UUID          id,
        BigDecimal    ask,
        BigDecimal    bid,
        Long          volume,
        LocalDateTime time,
        Integer       version,
        UUID          equityId
    ) {
        this.id = id;
        this.ask = ask;
        this.bid = bid;
        this.volume = volume;
        this.time = time;
        this.version = version;
        this.equityId = equityId;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAsk() {
        return this.ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getBid() {
        return this.bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public Long getVolume() {
        return this.volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getEquityId() {
        return this.equityId;
    }

    public void setEquityId(UUID equityId) {
        this.equityId = equityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ticks (");

        sb.append(id);
        sb.append(", ").append(ask);
        sb.append(", ").append(bid);
        sb.append(", ").append(volume);
        sb.append(", ").append(time);
        sb.append(", ").append(version);
        sb.append(", ").append(equityId);

        sb.append(")");
        return sb.toString();
    }
}
