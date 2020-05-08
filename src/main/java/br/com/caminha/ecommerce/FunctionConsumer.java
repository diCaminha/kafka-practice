package br.com.caminha.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface FunctionConsumer {

    public void parse(ConsumerRecord<String, String> record);
}
