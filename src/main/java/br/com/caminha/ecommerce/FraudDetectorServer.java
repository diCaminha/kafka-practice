package br.com.caminha.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorServer {

    public static void main(String[] args) {
        var kafkaServer = new KafkaServer("ECOMMERCE_NEW_ORDER", FraudDetectorServer::parse);
        kafkaServer.run();
    }

    static void parse(ConsumerRecord<String, String> record) {
        System.out.println("Processing new order...");
        System.out.println(record.value());
    }
}
