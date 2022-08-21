CREATE TABLE dict.currency
(
    id           uuid         NOT NULL,
    code         varchar(3)   NOT NULL UNIQUE,
    name         varchar(255) NOT NULL,
    numeric_code int8,
    CONSTRAINT currencies_pkey
        PRIMARY KEY (id)
);
COMMENT
ON COLUMN dict.currency.code IS 'alphabetic code';

CREATE TABLE dict.security
(
    id          uuid         NOT NULL,
    code        varchar(255) NOT NULL UNIQUE,
    name        text,
    commission  numeric(19, 4),
    step        numeric(19, 4),
    active      numeric(19, 4),
    version     int4,
    currency_id uuid         NOT NULL,
    country_id  uuid         NOT NULL,
    stock_id    uuid         NOT NULL,
    CONSTRAINT equities_pkey
        PRIMARY KEY (id)
);

ALTER TABLE dict.security
    ADD CONSTRAINT FKequities187020 FOREIGN KEY (currency_id) REFERENCES dict.currency (id);
ALTER TABLE dict.security
    ADD CONSTRAINT FKequities215282 FOREIGN KEY (country_id) REFERENCES md.country (id);
ALTER TABLE dict.security
    ADD CONSTRAINT FKequities433591 FOREIGN KEY (stock_id) REFERENCES md.stock (id);