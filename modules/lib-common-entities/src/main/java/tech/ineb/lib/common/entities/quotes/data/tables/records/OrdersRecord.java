/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables.records;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import tech.ineb.lib.common.entities.quotes.data.tables.Orders;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrdersRecord extends UpdatableRecordImpl<OrdersRecord> implements Record9<UUID, BigDecimal, BigDecimal, BigDecimal, Integer, Integer, LocalDateTime, Integer, UUID> {

    private static final long serialVersionUID = -1456002245;

    /**
     * Setter for <code>history.orders.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>history.orders.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>history.orders.volume</code>.
     */
    public void setVolume(BigDecimal value) {
        set(1, value);
    }

    /**
     * Getter for <code>history.orders.volume</code>.
     */
    public BigDecimal getVolume() {
        return (BigDecimal) get(1);
    }

    /**
     * Setter for <code>history.orders.price</code>.
     */
    public void setPrice(BigDecimal value) {
        set(2, value);
    }

    /**
     * Getter for <code>history.orders.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(2);
    }

    /**
     * Setter for <code>history.orders.amount</code>.
     */
    public void setAmount(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>history.orders.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>history.orders.order_type</code>.
     */
    public void setOrderType(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>history.orders.order_type</code>.
     */
    public Integer getOrderType() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>history.orders.order_status</code>.
     */
    public void setOrderStatus(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>history.orders.order_status</code>.
     */
    public Integer getOrderStatus() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>history.orders.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>history.orders.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>history.orders.version</code>.
     */
    public void setVersion(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>history.orders.version</code>.
     */
    public Integer getVersion() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>history.orders.equity_id</code>.
     */
    public void setEquityId(UUID value) {
        set(8, value);
    }

    /**
     * Getter for <code>history.orders.equity_id</code>.
     */
    public UUID getEquityId() {
        return (UUID) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<UUID, BigDecimal, BigDecimal, BigDecimal, Integer, Integer, LocalDateTime, Integer, UUID> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<UUID, BigDecimal, BigDecimal, BigDecimal, Integer, Integer, LocalDateTime, Integer, UUID> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Orders.ORDERS.ID;
    }

    @Override
    public Field<BigDecimal> field2() {
        return Orders.ORDERS.VOLUME;
    }

    @Override
    public Field<BigDecimal> field3() {
        return Orders.ORDERS.PRICE;
    }

    @Override
    public Field<BigDecimal> field4() {
        return Orders.ORDERS.AMOUNT;
    }

    @Override
    public Field<Integer> field5() {
        return Orders.ORDERS.ORDER_TYPE;
    }

    @Override
    public Field<Integer> field6() {
        return Orders.ORDERS.ORDER_STATUS;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Orders.ORDERS.CREATED;
    }

    @Override
    public Field<Integer> field8() {
        return Orders.ORDERS.VERSION;
    }

    @Override
    public Field<UUID> field9() {
        return Orders.ORDERS.EQUITY_ID;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public BigDecimal component2() {
        return getVolume();
    }

    @Override
    public BigDecimal component3() {
        return getPrice();
    }

    @Override
    public BigDecimal component4() {
        return getAmount();
    }

    @Override
    public Integer component5() {
        return getOrderType();
    }

    @Override
    public Integer component6() {
        return getOrderStatus();
    }

    @Override
    public LocalDateTime component7() {
        return getCreated();
    }

    @Override
    public Integer component8() {
        return getVersion();
    }

    @Override
    public UUID component9() {
        return getEquityId();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public BigDecimal value2() {
        return getVolume();
    }

    @Override
    public BigDecimal value3() {
        return getPrice();
    }

    @Override
    public BigDecimal value4() {
        return getAmount();
    }

    @Override
    public Integer value5() {
        return getOrderType();
    }

    @Override
    public Integer value6() {
        return getOrderStatus();
    }

    @Override
    public LocalDateTime value7() {
        return getCreated();
    }

    @Override
    public Integer value8() {
        return getVersion();
    }

    @Override
    public UUID value9() {
        return getEquityId();
    }

    @Override
    public OrdersRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public OrdersRecord value2(BigDecimal value) {
        setVolume(value);
        return this;
    }

    @Override
    public OrdersRecord value3(BigDecimal value) {
        setPrice(value);
        return this;
    }

    @Override
    public OrdersRecord value4(BigDecimal value) {
        setAmount(value);
        return this;
    }

    @Override
    public OrdersRecord value5(Integer value) {
        setOrderType(value);
        return this;
    }

    @Override
    public OrdersRecord value6(Integer value) {
        setOrderStatus(value);
        return this;
    }

    @Override
    public OrdersRecord value7(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public OrdersRecord value8(Integer value) {
        setVersion(value);
        return this;
    }

    @Override
    public OrdersRecord value9(UUID value) {
        setEquityId(value);
        return this;
    }

    @Override
    public OrdersRecord values(UUID value1, BigDecimal value2, BigDecimal value3, BigDecimal value4, Integer value5, Integer value6, LocalDateTime value7, Integer value8, UUID value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrdersRecord
     */
    public OrdersRecord() {
        super(Orders.ORDERS);
    }

    /**
     * Create a detached, initialised OrdersRecord
     */
    public OrdersRecord(UUID id, BigDecimal volume, BigDecimal price, BigDecimal amount, Integer orderType, Integer orderStatus, LocalDateTime created, Integer version, UUID equityId) {
        super(Orders.ORDERS);

        set(0, id);
        set(1, volume);
        set(2, price);
        set(3, amount);
        set(4, orderType);
        set(5, orderStatus);
        set(6, created);
        set(7, version);
        set(8, equityId);
    }
}
