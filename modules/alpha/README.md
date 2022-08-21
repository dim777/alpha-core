# Configuration
## Installation
## Deploy
## Hosts config
- 127.0.0.1			zookeeper
- 127.0.0.1			kafka
- 127.0.0.1			postgres
- 127.0.0.1			debezium-connect
## Avro plugin
clean generateAvroProtocol generateAvroJava
## Reset topics prior startup
* kafka-streams-application-reset --application-id kstreams-enriched-app 
* kafka-consumer-groups --bootstrap-server kafka:9092 --group kstreams-enriched-app --topic postgres.als.limit --reset-offsets --to-earliest --execute 
* kafka-consumer-groups --bootstrap-server kafka:9092 --group kstreams-enriched-app --topic postgres.als.limit_child_link --reset-offsets --to-earliest --execute 
* kafka-topics --zookeeper zookeeper:2181 --delete --topic store.utilization_results