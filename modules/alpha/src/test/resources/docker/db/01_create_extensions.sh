#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "market_data_usr" --dbname "market_data_db" <<-EOSQL
    
EOSQL