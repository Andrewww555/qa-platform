package org.qaplatform.observability;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Map;
import java.util.Properties;

public class TestEventPublisher {
    private final ObjectMapper mapper = new ObjectMapper();
    private final KafkaProducer<String, String> producer;

    public TestEventPublisher(String bootstrapServers) {
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
    }

    public void publish(String topic, String key, Map<String, Object> payload) throws Exception {
        producer.send(new ProducerRecord<>(topic, key, mapper.writeValueAsString(payload)));
    }
}
