package com.example.ampq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmpqApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmpqApplication.class, args);
    }
}
