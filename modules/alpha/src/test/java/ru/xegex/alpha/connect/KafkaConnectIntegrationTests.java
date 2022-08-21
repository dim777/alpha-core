package ru.xegex.alpha.connect;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KafkaConnectIntegrationTests {

    @Value("${debezium.connect.host}")
    private String connectHostname;
    @Value("${debezium.connect.restPort}")
    private String restPort;
    @Value("${debezium.connectorPg.name}")
    private String connectorName;

    @Value("${debezium.connectorPg.host}")
    private String host;
    @Value("${debezium.connectorPg.port}")
    private String port;
    @Value("${debezium.connectorPg.user}")
    private String user;
    @Value("${debezium.connectorPg.pass}")
    private String pass;
    @Value("${debezium.connectorPg.database}")
    private String database;

    private static WebTestClient webTestClient;

    /*@ClassRule
    public static DockerComposeRule dockerPostgres = DockerComposeRule.builder()
            .file("src/test/resources/docker/docker-compose.yml")

            .waitingForService("postgres", HealthChecks.toHaveAllPortsOpen())
            .waitingForHostNetworkedPort(15432, toBeOpen())

            .build();

    private static HealthCheck<DockerPort> toBeOpen() {
        return port -> SuccessOrFailure.fromBoolean(port.isListeningNow(), "" + "" + port + " was not open");
    }*/

    @BeforeClass
    public static void initialize() {
        webTestClient = WebTestClient
                .bindToServer()
                //.baseUrl("http://localhost:8080")
                .build();

    }

    /*@Test
    public void a_test_Docker_Kafka_Connect_Services_is_Live() throws InterruptedException, IOException {
        Assert.assertTrue(dockerPostgres.containers().container("postgres").state().isUp());
    }*/

    @Test
    public void b_whenConnectorExistsThenDeleteIt() {
        webTestClient
                .delete()
                .uri("http://" + connectHostname + ":" + restPort + "/connectors/" + connectorName)
                .exchange();

        webTestClient
                .delete()
                .uri("http://" + connectHostname + ":" + restPort + "/connectors/" + connectorName)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void c_whenTest_KafkaConnect_is_EmptyConnectorsList() {
        List<KafkaConnectConnector> expected = new ArrayList<>();

        webTestClient
                .get()
                .uri("http://" + connectHostname + ":" + restPort + "/connectors/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(KafkaConnectConnector.class)
                .isEqualTo(expected);
    }

    @Test
    public void d_whenTest_KafkaConnect_isEmpty_then_CreateConnector() throws InterruptedException {
        ConnectConfig config = new ConnectConfig();
        config.setConnectorClass("io.debezium.connector.postgresql.PostgresConnector");
        config.setTasksMax("1");
        config.setDatabaseHostname(host);
        config.setDatabasePort(port);
        config.setDatabaseUser(user);
        config.setDatabasePassword(pass);
        config.setDatabaseServerId("18979");
        config.setDatabaseServerName(host);
        config.setDatabaseDbName(database);
        //ru.gpb.risks.als.kstreamsenriched.config.setDatabaseWhitelist("kafka_connect_mock.limits");
        config.setDatabaseWhitelist("");
        //todo: move 2 configuration bootstrap servers
        config.setDatabaseHistoryKafkaBootstrapServers("kafka:9092");
        config.setDatabaseHistoryKafkaTopic("cdc-pg");
        config.setKeyConverterSchemasEnable(true);
        config.setValueConverterSchemasEnable(true);

        KafkaConnectConnector kafkaConnectConnector = new KafkaConnectConnector();
        kafkaConnectConnector.setName(connectorName);
        kafkaConnectConnector.setConfig(config);

        webTestClient.post()
                .uri("http://" + connectHostname + ":" + restPort + "/connectors/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(kafkaConnectConnector))
                .exchange()
                .expectStatus().isCreated();

        Thread.sleep(5000);
    }
}

