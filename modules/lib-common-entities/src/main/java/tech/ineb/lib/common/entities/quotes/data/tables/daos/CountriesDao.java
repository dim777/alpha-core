/*
 * This file is generated by jOOQ.
 */
package tech.ineb.lib.common.entities.quotes.data.tables.daos;


import java.util.List;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import tech.ineb.lib.common.entities.quotes.data.tables.Countries;
import tech.ineb.lib.common.entities.quotes.data.tables.records.CountriesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CountriesDao extends DAOImpl<CountriesRecord, tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries, UUID> {

    /**
     * Create a new CountriesDao without any configuration
     */
    public CountriesDao() {
        super(Countries.COUNTRIES, tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries.class);
    }

    /**
     * Create a new CountriesDao with an attached configuration
     */
    public CountriesDao(Configuration configuration) {
        super(Countries.COUNTRIES, tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries.class, configuration);
    }

    @Override
    public UUID getId(tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchRangeOfId(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Countries.COUNTRIES.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchById(UUID... values) {
        return fetch(Countries.COUNTRIES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries fetchOneById(UUID value) {
        return fetchOne(Countries.COUNTRIES.ID, value);
    }

    /**
     * Fetch records that have <code>code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchRangeOfCode(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Countries.COUNTRIES.CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchByCode(Long... values) {
        return fetch(Countries.COUNTRIES.CODE, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Countries.COUNTRIES.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchByName(String... values) {
        return fetch(Countries.COUNTRIES.NAME, values);
    }

    /**
     * Fetch records that have <code>full_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchRangeOfFullName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Countries.COUNTRIES.FULL_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>full_name IN (values)</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchByFullName(String... values) {
        return fetch(Countries.COUNTRIES.FULL_NAME, values);
    }

    /**
     * Fetch records that have <code>alpha2 BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchRangeOfAlpha2(String lowerInclusive, String upperInclusive) {
        return fetchRange(Countries.COUNTRIES.ALPHA2, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>alpha2 IN (values)</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchByAlpha2(String... values) {
        return fetch(Countries.COUNTRIES.ALPHA2, values);
    }

    /**
     * Fetch records that have <code>alpha3 BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchRangeOfAlpha3(String lowerInclusive, String upperInclusive) {
        return fetchRange(Countries.COUNTRIES.ALPHA3, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>alpha3 IN (values)</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchByAlpha3(String... values) {
        return fetch(Countries.COUNTRIES.ALPHA3, values);
    }

    /**
     * Fetch records that have <code>version BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchRangeOfVersion(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Countries.COUNTRIES.VERSION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>version IN (values)</code>
     */
    public List<tech.ineb.lib.common.entities.quotes.data.tables.pojos.Countries> fetchByVersion(Integer... values) {
        return fetch(Countries.COUNTRIES.VERSION, values);
    }
}