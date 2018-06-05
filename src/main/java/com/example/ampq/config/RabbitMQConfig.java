package com.example.ampq.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BaoZhou
 * @date 2018/6/5
 */

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Bean
    public MessageConverter MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
