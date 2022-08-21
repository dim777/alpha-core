package ru.xegex.alpha.connect;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class KafkaConnectConnector implements Serializable {
    private static final long serialVersionUID = -3375159358757648792L;

    private String name;
    @JsonProperty("config")
    private ConnectConfig config;
}
