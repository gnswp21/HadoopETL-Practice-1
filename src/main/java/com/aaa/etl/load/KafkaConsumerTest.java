package com.aaa.etl.load;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerTest {
    public static void main(String[] args) {
        // kafka 객체 생성
        Properties kafkaConsProperty = new Properties();
        kafkaConsProperty.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        kafkaConsProperty.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaConsProperty.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaConsProperty.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        kafkaConsProperty.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        Consumer<String, String> consumer =
                new KafkaConsumer<>(kafkaConsProperty);

        consumer.subscribe(Collections.singletonList("topic_house_income_ann"));

        String message = null;

        try{
            while (true) {

                ConsumerRecords<String, String> records =
                        consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord record : records) {
                    message = (String) record.value();
                    System.out.println(message);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            consumer.close();
        }

    }
}
