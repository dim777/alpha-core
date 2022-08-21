package ru.xegex.alpha.connect;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ConnectConfig implements Serializable {
    private static final long serialVersionUID = -3375159358757648792L;

    @JsonProperty("connector.class")
    private String connectorClass;

    @JsonProperty("tasks.max")
    private String tasksMax;

    @JsonProperty("database.hostname")
    private String databaseHostname;

    @JsonProperty("database.port")
    private String databasePort;

    @JsonProperty("database.user")
    private String databaseUser;

    @JsonProperty("database.dbname")
    private String databaseDbName;

    @JsonProperty("database.password")
    private String databasePassword;

    @JsonProperty("database.server.id")
    private String databaseServerId;

    @JsonProperty("database.server.name")
    private String databaseServerName;

    @JsonProperty("table.whitelist")
    private String databaseWhitelist;

    @JsonProperty("database.history.kafka.bootstrap.servers")
    private String databaseHistoryKafkaBootstrapServers;

    @JsonProperty("database.history.kafka.topic")
    private String databaseHistoryKafkaTopic;

    @JsonProperty("key.converter.schemas.enable")
    private Boolean keyConverterSchemasEnable;

    @JsonProperty("value.converter.schemas.enable")
    private Boolean valueConverterSchemasEnable;
}
