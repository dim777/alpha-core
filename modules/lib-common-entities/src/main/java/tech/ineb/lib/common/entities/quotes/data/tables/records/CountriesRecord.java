/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables.records;


import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import tech.ineb.lib.common.entities.quotes.data.tables.Countries;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CountriesRecord extends UpdatableRecordImpl<CountriesRecord> implements Record7<UUID, Long, String, String, String, String, Integer> {

    private static final long serialVersionUID = -1946621720;

    /**
     * Setter for <code>history.countries.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>history.countries.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>history.countries.code</code>.
     */
    public void setCode(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>history.countries.code</code>.
     */
    public Long getCode() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>history.countries.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>history.countries.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>history.countries.full_name</code>.
     */
    public void setFullName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>history.countries.full_name</code>.
     */
    public String getFullName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>history.countries.alpha2</code>.
     */
    public void setAlpha2(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>history.countries.alpha2</code>.
     */
    public String getAlpha2() {
        return (String) get(4);
    }

    /**
     * Setter for <code>history.countries.alpha3</code>.
     */
    public void setAlpha3(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>history.countries.alpha3</code>.
     */
    public String getAlpha3() {
        return (String) get(5);
    }

    /**
     * Setter for <code>history.countries.version</code>.
     */
    public void setVersion(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>history.countries.version</code>.
     */
    public Integer getVersion() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<UUID, Long, String, String, String, String, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<UUID, Long, String, String, String, String, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Countries.COUNTRIES.ID;
    }

    @Override
    public Field<Long> field2() {
        return Countries.COUNTRIES.CODE;
    }

    @Override
    public Field<String> field3() {
        return Countries.COUNTRIES.NAME;
    }

    @Override
    public Field<String> field4() {
        return Countries.COUNTRIES.FULL_NAME;
    }

    @Override
    public Field<String> field5() {
        return Countries.COUNTRIES.ALPHA2;
    }

    @Override
    public Field<String> field6() {
        return Countries.COUNTRIES.ALPHA3;
    }

    @Override
    public Field<Integer> field7() {
        return Countries.COUNTRIES.VERSION;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getCode();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getFullName();
    }

    @Override
    public String component5() {
        return getAlpha2();
    }

    @Override
    public String component6() {
        return getAlpha3();
    }

    @Override
    public Integer component7() {
        return getVersion();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getCode();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getFullName();
    }

    @Override
    public String value5() {
        return getAlpha2();
    }

    @Override
    public String value6() {
        return getAlpha3();
    }

    @Override
    public Integer value7() {
        return getVersion();
    }

    @Override
    public CountriesRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public CountriesRecord value2(Long value) {
        setCode(value);
        return this;
    }

    @Override
    public CountriesRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public CountriesRecord value4(String value) {
        setFullName(value);
        return this;
    }

    @Override
    public CountriesRecord value5(String value) {
        setAlpha2(value);
        return this;
    }

    @Override
    public CountriesRecord value6(String value) {
        setAlpha3(value);
        return this;
    }

    @Override
    public CountriesRecord value7(Integer value) {
        setVersion(value);
        return this;
    }

    @Override
    public CountriesRecord values(UUID value1, Long value2, String value3, String value4, String value5, String value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CountriesRecord
     */
    public CountriesRecord() {
        super(Countries.COUNTRIES);
    }

    /**
     * Create a detached, initialised CountriesRecord
     */
    public CountriesRecord(UUID id, Long code, String name, String fullName, String alpha2, String alpha3, Integer version) {
        super(Countries.COUNTRIES);

        set(0, id);
        set(1, code);
        set(2, name);
        set(3, fullName);
        set(4, alpha2);
        set(5, alpha3);
        set(6, version);
    }
}