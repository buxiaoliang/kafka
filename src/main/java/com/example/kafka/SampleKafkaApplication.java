package com.example.kafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by bur on 2018/9/10.
 */
@SpringBootApplication
public class SampleKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleKafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(Producer producer) {
        return (args) -> producer.send(new SampleMessage(1, "A simple test message"));
    }

}
