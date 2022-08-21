CREATE TABLE md.currency (id uuid NOT NULL, code varchar(3) NOT NULL UNIQUE, name varchar(255) NOT NULL, numeric_code int8, CONSTRAINT currencies_pkey PRIMARY KEY (id));
COMMENT ON COLUMN md.currency.code IS 'alphabetic code';
CREATE TABLE md."order" (id uuid NOT NULL, volume numeric(19, 4) NOT NULL, price numeric(19, 4) NOT NULL, amount numeric(19, 4) NOT NULL, order_type int NOT NULL, order_status int NOT NULL, created timestamp NOT NULL, equity_id uuid NOT NULL, version int4, CONSTRAINT orders_pkey PRIMARY KEY (id), CONSTRAINT CK_order_type CHECK (order_type IN (0, 1, 2, 3, 4, 5, 6, 7, 8)), CONSTRAINT CK_order_status CHECK (order_status IN (0, 1)));
CREATE TABLE md.quote (id uuid NOT NULL, "open" numeric(19, 4) NOT NULL, high numeric(19, 4) NOT NULL, low numeric(19, 4) NOT NULL, "close" numeric(19, 4) NOT NULL, time timestamp NOT NULL, time_frame int NOT NULL, equity_id uuid NOT NULL, version int4, CONSTRAINT quotes_pkey PRIMARY KEY (id), CONSTRAINT CK_time_frame CHECK (time_frame IN (0, 1, 2, 3, 4, 5, 6, 7)));
CREATE TABLE md.tick (id uuid NOT NULL, ask numeric(19, 4) NOT NULL, bid numeric(19, 4) NOT NULL, volume int8 NOT NULL, time timestamp NOT NULL, equity_id uuid NOT NULL, CONSTRAINT ticks_pkey PRIMARY KEY (id));
CREATE TABLE md.country (id uuid NOT NULL, code int8 NOT NULL UNIQUE, name varchar(255), full_name text, alpha2 varchar(255), alpha3 varchar(255), CONSTRAINT countries_pkey PRIMARY KEY (id));
CREATE TABLE md.stock (id uuid NOT NULL, code varchar(255) NOT NULL UNIQUE, name text, CONSTRAINT stocks_pkey PRIMARY KEY (id));
CREATE TABLE md.equity (id uuid NOT NULL, code varchar(255) NOT NULL UNIQUE, name text, commission numeric(19, 4), step numeric(19, 4), active numeric(19, 4), version int4, currency_id uuid NOT NULL, country_id uuid NOT NULL, stock_id uuid NOT NULL, CONSTRAINT equities_pkey PRIMARY KEY (id));
ALTER TABLE md."order" ADD CONSTRAINT FKorders661644 FOREIGN KEY (equity_id) REFERENCES md.equity (id);
ALTER TABLE md.tick ADD CONSTRAINT FKticks788156 FOREIGN KEY (equity_id) REFERENCES md.equity (id);
ALTER TABLE md.equity ADD CONSTRAINT FKequities187020 FOREIGN KEY (currency_id) REFERENCES md.currency (id);
ALTER TABLE md.equity ADD CONSTRAINT FKequities215282 FOREIGN KEY (country_id) REFERENCES md.country (id);
ALTER TABLE md.equity ADD CONSTRAINT FKequities433591 FOREIGN KEY (stock_id) REFERENCES md.stock (id);
ALTER TABLE md.quote ADD CONSTRAINT FKquote115834 FOREIGN KEY (equity_id) REFERENCES md.equity (id);
