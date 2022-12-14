FROM postgres:11.6 AS build

ARG USE_POSTGIS=true
ENV PLUGIN_VERSION=v1.6.2.Final
ENV PROTOC_VERSION=1.3

ENV WAL2JSON_COMMIT_ID=92b33c7d7c2fccbeb9f79455dafbc92e87e00ddd

# Install the packages which will be required to get everything to compile
RUN apt-get update \
    && apt-get install -f -y --no-install-recommends \
        software-properties-common \
        build-essential \
        pkg-config \
        openssl \
        krb5-multidev \
        libkrb5-dev \
        libssl-dev \
        git \
        postgresql-server-dev-$PG_MAJOR \
    && add-apt-repository "deb http://ftp.debian.org/debian testing main contrib" \
    && apt-get update && apt-get install -f -y --no-install-recommends \
        libprotobuf-c-dev=$PROTOC_VERSION.* \
    && rm -rf /var/lib/apt/lists/*

# Compile the plugin from sources and install it
RUN git clone https://github.com/debezium/postgres-decoderbufs -b $PLUGIN_VERSION --single-branch \
    && cd /postgres-decoderbufs \
    && make && make install \
    && cd / \
    && rm -rf postgres-decoderbufs

RUN git clone https://github.com/eulerto/wal2json -b master --single-branch \
    && cd /wal2json \
    && git checkout $WAL2JSON_COMMIT_ID \
    && make && make install \
    && cd / \
    && rm -rf wal2json

ENV USE_PGXS=1

RUN cd /usr/local/src \
    && git clone https://github.com/EnterpriseDB/pldebugger.git -b master --single-branch \
    && cd pldebugger \
    && make && make install \
    && cd /

FROM postgres:11.6

LABEL maintainer="Ineb Tech"

ENV POSTGIS_VERSION=2.5

RUN apt-get update \
    && apt-get install -f -y --no-install-recommends \
        software-properties-common \
    && if [ "$USE_POSTGIS" != "false" ]; then apt-get install -f -y --no-install-recommends \
        postgresql-$PG_MAJOR-postgis-$POSTGIS_VERSION \
        postgresql-$PG_MAJOR-postgis-$POSTGIS_VERSION-scripts \
        postgis; \
       fi \
    && add-apt-repository "deb http://ftp.debian.org/debian testing main contrib" \
    && apt-get update && apt-get install -f -y --no-install-recommends \
        libprotobuf-c1 \
    && rm -rf /var/lib/apt/lists/*

COPY --from=build /usr/lib/postgresql/$PG_MAJOR/lib/decoderbufs.so /usr/lib/postgresql/$PG_MAJOR/lib/wal2json.so /usr/lib/postgresql/$PG_MAJOR/lib/plugin_debugger.so /usr/lib/postgresql/$PG_MAJOR/lib/
COPY --from=build /usr/share/postgresql/$PG_MAJOR/extension/decoderbufs.control /usr/share/postgresql/$PG_MAJOR/extension/
COPY --from=build /usr/local/src/pldebugger /usr/local/src/pldebugger
COPY --from=build /usr/local/src/pldebugger/pldbgapi.control /usr/share/postgresql/$PG_MAJOR/extension/pldbgapi.control

# Copy the custom configuration which will be passed down to the server (using a .sample file is the preferred way of doing it by
# the base Docker image)
COPY postgresql.conf.sample /usr/share/postgresql/postgresql.conf.sample

# Copy the script which will initialize the replication permissions
COPY /docker-entrypoint-initdb.d /docker-entrypoint-initdb.d