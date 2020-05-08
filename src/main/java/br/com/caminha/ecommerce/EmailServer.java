package br.com.caminha.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailServer {

    public static void main(String[] args) {
        var kafkaServer = new KafkaServer("ECOMMERCE_SEND_EMAIL", EmailServer::parse);
        kafkaServer.run();
    }

    static void parse(ConsumerRecord<String, String> record) {
        System.out.println("Here simulating the email being sending");
        System.out.println("Message of email: " + record.value());
    }
}
