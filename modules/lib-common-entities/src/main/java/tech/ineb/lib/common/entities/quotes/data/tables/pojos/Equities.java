/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Equities implements Serializable {

    private static final long serialVersionUID = -1461750126;

    private UUID       id;
    private String     code;
    private String     name;
    private BigDecimal commission;
    private BigDecimal step;
    private BigDecimal active;
    private Integer    version;
    private UUID       currencyId;
    private UUID       countryId;
    private UUID       stockId;

    public Equities() {}

    public Equities(Equities value) {
        this.id = value.id;
        this.code = value.code;
        this.name = value.name;
        this.commission = value.commission;
        this.step = value.step;
        this.active = value.active;
        this.version = value.version;
        this.currencyId = value.currencyId;
        this.countryId = value.countryId;
        this.stockId = value.stockId;
    }

    public Equities(
        UUID       id,
        String     code,
        String     name,
        BigDecimal commission,
        BigDecimal step,
        BigDecimal active,
        Integer    version,
        UUID       currencyId,
        UUID       countryId,
        UUID       stockId
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.commission = commission;
        this.step = step;
        this.active = active;
        this.version = version;
        this.currencyId = currencyId;
        this.countryId = countryId;
        this.stockId = stockId;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCommission() {
        return this.commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getStep() {
        return this.step;
    }

    public void setStep(BigDecimal step) {
        this.step = step;
    }

    public BigDecimal getActive() {
        return this.active;
    }

    public void setActive(BigDecimal active) {
        this.active = active;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(UUID currencyId) {
        this.currencyId = currencyId;
    }

    public UUID getCountryId() {
        return this.countryId;
    }

    public void setCountryId(UUID countryId) {
        this.countryId = countryId;
    }

    public UUID getStockId() {
        return this.stockId;
    }

    public void setStockId(UUID stockId) {
        this.stockId = stockId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Equities (");

        sb.append(id);
        sb.append(", ").append(code);
        sb.append(", ").append(name);
        sb.append(", ").append(commission);
        sb.append(", ").append(step);
        sb.append(", ").append(active);
        sb.append(", ").append(version);
        sb.append(", ").append(currencyId);
        sb.append(", ").append(countryId);
        sb.append(", ").append(stockId);

        sb.append(")");
        return sb.toString();
    }
}
