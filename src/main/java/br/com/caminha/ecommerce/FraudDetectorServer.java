package br.com.caminha.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class FraudDetectorServer {

    public static void main(String[] args) {

        var consumer = new KafkaConsumer<String, String>(properties());
        while(true) {
            consumer.subscribe(Collections.singletonList("ECOMMERCE_NEW_ORDER"));
            var records = consumer.poll(Duration.ofMillis(100));

            if (records.isEmpty()) {
                System.out.println("Orders not found");
                continue;
            }
            for(var record: records) {
                System.out.println("Processing new order...");
                System.out.println(record.value());
                System.out.println("Processing new order...");
            }
        }

    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectorServer.class.getName());
        return properties;

    }
}
