/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables.records;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;

import tech.ineb.lib.common.entities.quotes.data.tables.Quotes;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QuotesRecord extends UpdatableRecordImpl<QuotesRecord> implements Record10<UUID, BigDecimal, BigDecimal, BigDecimal, BigDecimal, LocalDateTime, Integer, UUID, Integer, UUID> {

    private static final long serialVersionUID = 1835218479;

    /**
     * Setter for <code>history.quotes.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>history.quotes.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>history.quotes.open</code>.
     */
    public void setOpen(BigDecimal value) {
        set(1, value);
    }

    /**
     * Getter for <code>history.quotes.open</code>.
     */
    public BigDecimal getOpen() {
        return (BigDecimal) get(1);
    }

    /**
     * Setter for <code>history.quotes.high</code>.
     */
    public void setHigh(BigDecimal value) {
        set(2, value);
    }

    /**
     * Getter for <code>history.quotes.high</code>.
     */
    public BigDecimal getHigh() {
        return (BigDecimal) get(2);
    }

    /**
     * Setter for <code>history.quotes.low</code>.
     */
    public void setLow(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>history.quotes.low</code>.
     */
    public BigDecimal getLow() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>history.quotes.close</code>.
     */
    public void setClose(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>history.quotes.close</code>.
     */
    public BigDecimal getClose() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>history.quotes.time</code>.
     */
    public void setTime(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>history.quotes.time</code>.
     */
    public LocalDateTime getTime() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>history.quotes.time_frame</code>.
     */
    public void setTimeFrame(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>history.quotes.time_frame</code>.
     */
    public Integer getTimeFrame() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>history.quotes.equity_id</code>.
     */
    public void setEquityId(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>history.quotes.equity_id</code>.
     */
    public UUID getEquityId() {
        return (UUID) get(7);
    }

    /**
     * Setter for <code>history.quotes.version</code>.
     */
    public void setVersion(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>history.quotes.version</code>.
     */
    public Integer getVersion() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>history.quotes.equitiesid</code>.
     */
    public void setEquitiesid(UUID value) {
        set(9, value);
    }

    /**
     * Getter for <code>history.quotes.equitiesid</code>.
     */
    public UUID getEquitiesid() {
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
    public Row10<UUID, BigDecimal, BigDecimal, BigDecimal, BigDecimal, LocalDateTime, Integer, UUID, Integer, UUID> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<UUID, BigDecimal, BigDecimal, BigDecimal, BigDecimal, LocalDateTime, Integer, UUID, Integer, UUID> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Quotes.QUOTES.ID;
    }

    @Override
    public Field<BigDecimal> field2() {
        return Quotes.QUOTES.OPEN;
    }

    @Override
    public Field<BigDecimal> field3() {
        return Quotes.QUOTES.HIGH;
    }

    @Override
    public Field<BigDecimal> field4() {
        return Quotes.QUOTES.LOW;
    }

    @Override
    public Field<BigDecimal> field5() {
        return Quotes.QUOTES.CLOSE;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Quotes.QUOTES.TIME;
    }

    @Override
    public Field<Integer> field7() {
        return Quotes.QUOTES.TIME_FRAME;
    }

    @Override
    public Field<UUID> field8() {
        return Quotes.QUOTES.EQUITY_ID;
    }

    @Override
    public Field<Integer> field9() {
        return Quotes.QUOTES.VERSION;
    }

    @Override
    public Field<UUID> field10() {
        return Quotes.QUOTES.EQUITIESID;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public BigDecimal component2() {
        return getOpen();
    }

    @Override
    public BigDecimal component3() {
        return getHigh();
    }

    @Override
    public BigDecimal component4() {
        return getLow();
    }

    @Override
    public BigDecimal component5() {
        return getClose();
    }

    @Override
    public LocalDateTime component6() {
        return getTime();
    }

    @Override
    public Integer component7() {
        return getTimeFrame();
    }

    @Override
    public UUID component8() {
        return getEquityId();
    }

    @Override
    public Integer component9() {
        return getVersion();
    }

    @Override
    public UUID component10() {
        return getEquitiesid();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public BigDecimal value2() {
        return getOpen();
    }

    @Override
    public BigDecimal value3() {
        return getHigh();
    }

    @Override
    public BigDecimal value4() {
        return getLow();
    }

    @Override
    public BigDecimal value5() {
        return getClose();
    }

    @Override
    public LocalDateTime value6() {
        return getTime();
    }

    @Override
    public Integer value7() {
        return getTimeFrame();
    }

    @Override
    public UUID value8() {
        return getEquityId();
    }

    @Override
    public Integer value9() {
        return getVersion();
    }

    @Override
    public UUID value10() {
        return getEquitiesid();
    }

    @Override
    public QuotesRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public QuotesRecord value2(BigDecimal value) {
        setOpen(value);
        return this;
    }

    @Override
    public QuotesRecord value3(BigDecimal value) {
        setHigh(value);
        return this;
    }

    @Override
    public QuotesRecord value4(BigDecimal value) {
        setLow(value);
        return this;
    }

    @Override
    public QuotesRecord value5(BigDecimal value) {
        setClose(value);
        return this;
    }

    @Override
    public QuotesRecord value6(LocalDateTime value) {
        setTime(value);
        return this;
    }

    @Override
    public QuotesRecord value7(Integer value) {
        setTimeFrame(value);
        return this;
    }

    @Override
    public QuotesRecord value8(UUID value) {
        setEquityId(value);
        return this;
    }

    @Override
    public QuotesRecord value9(Integer value) {
        setVersion(value);
        return this;
    }

    @Override
    public QuotesRecord value10(UUID value) {
        setEquitiesid(value);
        return this;
    }

    @Override
    public QuotesRecord values(UUID value1, BigDecimal value2, BigDecimal value3, BigDecimal value4, BigDecimal value5, LocalDateTime value6, Integer value7, UUID value8, Integer value9, UUID value10) {
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
     * Create a detached QuotesRecord
     */
    public QuotesRecord() {
        super(Quotes.QUOTES);
    }

    /**
     * Create a detached, initialised QuotesRecord
     */
    public QuotesRecord(UUID id, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, LocalDateTime time, Integer timeFrame, UUID equityId, Integer version, UUID equitiesid) {
        super(Quotes.QUOTES);

        set(0, id);
        set(1, open);
        set(2, high);
        set(3, low);
        set(4, close);
        set(5, time);
        set(6, timeFrame);
        set(7, equityId);
        set(8, version);
        set(9, equitiesid);
    }
}
