/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import tech.ineb.lib.common.entities.quotes.data.History;
import tech.ineb.lib.common.entities.quotes.data.Keys;
import tech.ineb.lib.common.entities.quotes.data.tables.records.CountriesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Countries extends TableImpl<CountriesRecord> {

    private static final long serialVersionUID = 1012138534;

    /**
     * The reference instance of <code>history.countries</code>
     */
    public static final Countries COUNTRIES = new Countries();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CountriesRecord> getRecordType() {
        return CountriesRecord.class;
    }

    /**
     * The column <code>history.countries.id</code>.
     */
    public final TableField<CountriesRecord, UUID> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>history.countries.code</code>.
     */
    public final TableField<CountriesRecord, Long> CODE = createField(DSL.name("code"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>history.countries.name</code>.
     */
    public final TableField<CountriesRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>history.countries.full_name</code>.
     */
    public final TableField<CountriesRecord, String> FULL_NAME = createField(DSL.name("full_name"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>history.countries.alpha2</code>.
     */
    public final TableField<CountriesRecord, String> ALPHA2 = createField(DSL.name("alpha2"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>history.countries.alpha3</code>.
     */
    public final TableField<CountriesRecord, String> ALPHA3 = createField(DSL.name("alpha3"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>history.countries.version</code>.
     */
    public final TableField<CountriesRecord, Integer> VERSION = createField(DSL.name("version"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>history.countries</code> table reference
     */
    public Countries() {
        this(DSL.name("countries"), null);
    }

    /**
     * Create an aliased <code>history.countries</code> table reference
     */
    public Countries(String alias) {
        this(DSL.name(alias), COUNTRIES);
    }

    /**
     * Create an aliased <code>history.countries</code> table reference
     */
    public Countries(Name alias) {
        this(alias, COUNTRIES);
    }

    private Countries(Name alias, Table<CountriesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Countries(Name alias, Table<CountriesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Countries(Table<O> child, ForeignKey<O, CountriesRecord> key) {
        super(child, key, COUNTRIES);
    }

    @Override
    public Schema getSchema() {
        return History.HISTORY;
    }

    @Override
    public UniqueKey<CountriesRecord> getPrimaryKey() {
        return Keys.COUNTRIES_PKEY;
    }

    @Override
    public List<UniqueKey<CountriesRecord>> getKeys() {
        return Arrays.<UniqueKey<CountriesRecord>>asList(Keys.COUNTRIES_PKEY);
    }

    @Override
    public TableField<CountriesRecord, Integer> getRecordVersion() {
        return VERSION;
    }

    @Override
    public Countries as(String alias) {
        return new Countries(DSL.name(alias), this);
    }

    @Override
    public Countries as(Name alias) {
        return new Countries(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Countries rename(String name) {
        return new Countries(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Countries rename(Name name) {
        return new Countries(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<UUID, Long, String, String, String, String, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
