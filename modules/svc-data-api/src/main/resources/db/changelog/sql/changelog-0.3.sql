CREATE
    OR REPLACE FUNCTION md.quote_partition_func()
    RETURNS TRIGGER AS
$$
DECLARE
    partition_date    TEXT;
    partition_name    TEXT;
    start_of_month    TEXT;
    end_of_next_month TEXT;
BEGIN
    partition_date := to_char(NEW."time", 'YYYY_MM');
    partition_name := 'quote_' || partition_date;
    start_of_month := to_char((NEW."time"), 'YYYY-MM') || '-01';
    end_of_next_month := to_char((NEW."time" + interval '1 month'), 'YYYY-MM') || '-01';
    IF
        NOT EXISTS(SELECT 1 FROM information_schema.tables WHERE table_name = partition_name)
    THEN
        RAISE NOTICE 'A partition has been created % for tbl = quote', partition_name;
        EXECUTE format(
                E'CREATE TABLE %I (CHECK ( date_trunc(\'day\', "time") >= ''%s'' AND date_trunc(\'day\', "time") < ''%s'')) INHERITS (md.quote)',
                partition_name, start_of_month, end_of_next_month);
-- EXECUTE format('GRANT SELECT ON TABLE %I TO readonly', partition_name); -- use this if you use role based permission
    END IF;
    EXECUTE format('INSERT INTO md.quote ' ||
                   '(id, "open", high, low, "close", "time", time_frame, equity_id, "version", equitys_id) ' ||
                   'VALUES($1,$2,$3,$4,$5,$6,$7,$8,$9,$10);',
                   partition_name) using NEW.id, NEW."open", NEW.high, NEW.low, NEW."close", NEW."time",
        NEW.time_frame, NEW.equity_id, NEW."version", NEW.equitys_id;
    RETURN NULL;
END
$$
    LANGUAGE plpgsql;

CREATE TRIGGER insert_quote_trigger
    BEFORE INSERT
    ON md.quote
    FOR EACH ROW
EXECUTE PROCEDURE md.quote_partition_func();