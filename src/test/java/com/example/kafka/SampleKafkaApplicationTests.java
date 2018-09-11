package com.example.kafka;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bur on 2018/9/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}")
@EmbeddedKafka
public class SampleKafkaApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testVanillaExchange() throws Exception {
        long end = System.currentTimeMillis() + 10000;
        while (!this.outputCapture.toString().contains("A simple test message")
                && System.currentTimeMillis() < end) {
            Thread.sleep(250);
        }
        assertThat(this.outputCapture.toString()).contains("A simple test message");
    }

}