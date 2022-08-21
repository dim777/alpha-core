CREATE TABLE test.quotes (
id            uuid NOT NULL,
is_processed  boolean DEFAULT FALSE,
received_time timestamp NOT NULL,
market_time   timestamp NOT NULL,
CONSTRAINT quotes_pkey PRIMARY KEY (id));

create extension if not exists "uuid-ossp";

CREATE TABLE moex.ticks (
id            uuid NOT NULL DEFAULT uuid_generate_v4(),
security      varchar(255) NOT NULL,
code          varchar(255) NOT NULL,
ask           numeric(19, 4) NOT NULL,
ask_vol		    int NOT NULL,
bid           numeric(19, 4) NOT NULL,
bid_vol		    int NOT NULL,
change_time   varchar(255) NOT null,
CONSTRAINT ticks_pkey PRIMARY KEY (id));

CREATE TABLE test.transactions (
id            bigint NOT NULL,
CONSTRAINT transactions_pkey PRIMARY KEY (id));

CREATE TABLE moex.ticks (
id            uuid default uuid_generate_v4(),
code          varchar(255) NOT NULL,
ask           numeric(19, 4) NOT NULL,
ask_vol		    int NOT NULL,
bid           numeric(19, 4) NOT NULL,
bid_vol		    int NOT NULL,
change_time   varchar(255) NOT null);
CONSTRAINT ticks_pkey PRIMARY KEY (id));