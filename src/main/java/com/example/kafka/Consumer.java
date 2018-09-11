package com.example.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * Created by bur on 2018/9/10.
 */
@Component
class Consumer {

    @KafkaListener(topics = "testTopic")
    public void processMessage(SampleMessage message) {
        System.out.println("Received sample message [" + message + "]");
    }

}