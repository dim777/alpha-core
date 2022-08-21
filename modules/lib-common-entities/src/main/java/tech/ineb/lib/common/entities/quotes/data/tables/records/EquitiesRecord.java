/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables.records;


import java.math.BigDecimal;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;

import tech.ineb.lib.common.entities.quotes.data.tables.Equities;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EquitiesRecord extends UpdatableRecordImpl<EquitiesRecord> implements Record10<UUID, String, String, BigDecimal, BigDecimal, BigDecimal, Integer, UUID, UUID, UUID> {

    private static final long serialVersionUID = 508089533;

    /**
     * Setter for <code>history.equities.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>history.equities.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>history.equities.code</code>.
     */
    public void setCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>history.equities.code</code>.
     */
    public String getCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>history.equities.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>history.equities.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>history.equities.commission</code>.
     */
    public void setCommission(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>history.equities.commission</code>.
     */
    public BigDecimal getCommission() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>history.equities.step</code>.
     */
    public void setStep(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>history.equities.step</code>.
     */
    public BigDecimal getStep() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>history.equities.active</code>.
     */
    public void setActive(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>history.equities.active</code>.
     */
    public BigDecimal getActive() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>history.equities.version</code>.
     */
    public void setVersion(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>history.equities.version</code>.
     */
    public Integer getVersion() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>history.equities.currency_id</code>.
     */
    public void setCurrencyId(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>history.equities.currency_id</code>.
     */
    public UUID getCurrencyId() {
        return (UUID) get(7);
    }

    /**
     * Setter for <code>history.equities.country_id</code>.
     */
    public void setCountryId(UUID value) {
        set(8, value);
    }

    /**
     * Getter for <code>history.equities.country_id</code>.
     */
    public UUID getCountryId() {
        return (UUID) get(8);
    }

    /**
     * Setter for <code>history.equities.stock_id</code>.
     */
    public void setStockId(UUID value) {
        set(9, value);
    }

    /**
     * Getter for <code>history.equities.stock_id</code>.
     */
    public UUID getStockId() {
        return (UUID) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<UUID, String, String, BigDecimal, BigDecimal, BigDecimal, Integer, UUID, UUID, UUID> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<UUID, String, String, BigDecimal, BigDecimal, BigDecimal, Integer, UUID, UUID, UUID> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Equities.EQUITIES.ID;
    }

    @Override
    public Field<String> field2() {
        return Equities.EQUITIES.CODE;
    }

    @Override
    public Field<String> field3() {
        return Equities.EQUITIES.NAME;
    }

    @Override
    public Field<BigDecimal> field4() {
        return Equities.EQUITIES.COMMISSION;
    }

    @Override
    public Field<BigDecimal> field5() {
        return Equities.EQUITIES.STEP;
    }

    @Override
    public Field<BigDecimal> field6() {
        return Equities.EQUITIES.ACTIVE;
    }

    @Override
    public Field<Integer> field7() {
        return Equities.EQUITIES.VERSION;
    }

    @Override
    public Field<UUID> field8() {
        return Equities.EQUITIES.CURRENCY_ID;
    }

    @Override
    public Field<UUID> field9() {
        return Equities.EQUITIES.COUNTRY_ID;
    }

    @Override
    public Field<UUID> field10() {
        return Equities.EQUITIES.STOCK_ID;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getCode();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public BigDecimal component4() {
        return getCommission();
    }

    @Override
    public BigDecimal component5() {
        return getStep();
    }

    @Override
    public BigDecimal component6() {
        return getActive();
    }

    @Override
    public Integer component7() {
        return getVersion();
    }

    @Override
    public UUID component8() {
        return getCurrencyId();
    }

    @Override
    public UUID component9() {
        return getCountryId();
    }

    @Override
    public UUID component10() {
        return getStockId();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getCode();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public BigDecimal value4() {
        return getCommission();
    }

    @Override
    public BigDecimal value5() {
        return getStep();
    }

    @Override
    public BigDecimal value6() {
        return getActive();
    }

    @Override
    public Integer value7() {
        return getVersion();
    }

    @Override
    public UUID value8() {
        return getCurrencyId();
    }

    @Override
    public UUID value9() {
        return getCountryId();
    }

    @Override
    public UUID value10() {
        return getStockId();
    }

    @Override
    public EquitiesRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public EquitiesRecord value2(String value) {
        setCode(value);
        return this;
    }

    @Override
    public EquitiesRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public EquitiesRecord value4(BigDecimal value) {
        setCommission(value);
        return this;
    }

    @Override
    public EquitiesRecord value5(BigDecimal value) {
        setStep(value);
        return this;
    }

    @Override
    public EquitiesRecord value6(BigDecimal value) {
        setActive(value);
        return this;
    }

    @Override
    public EquitiesRecord value7(Integer value) {
        setVersion(value);
        return this;
    }

    @Override
    public EquitiesRecord value8(UUID value) {
        setCurrencyId(value);
        return this;
    }

    @Override
    public EquitiesRecord value9(UUID value) {
        setCountryId(value);
        return this;
    }

    @Override
    public EquitiesRecord value10(UUID value) {
        setStockId(value);
        return this;
    }

    @Override
    public EquitiesRecord values(UUID value1, String value2, String value3, BigDecimal value4, BigDecimal value5, BigDecimal value6, Integer value7, UUID value8, UUID value9, UUID value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EquitiesRecord
     */
    public EquitiesRecord() {
        super(Equities.EQUITIES);
    }

    /**
     * Create a detached, initialised EquitiesRecord
     */
    public EquitiesRecord(UUID id, String code, String name, BigDecimal commission, BigDecimal step, BigDecimal active, Integer version, UUID currencyId, UUID countryId, UUID stockId) {
        super(Equities.EQUITIES);

        set(0, id);
        set(1, code);
        set(2, name);
        set(3, commission);
        set(4, step);
        set(5, active);
        set(6, version);
        set(7, currencyId);
        set(8, countryId);
        set(9, stockId);
    }
}