package com.example.ampq;

import com.example.ampq.bean.testBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmpqApplicationTests {
    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "baozhou");
        map.put("age", 18);
        map.put("data", Arrays.asList("666", "你好", 123));
        rabbitTemplate.convertAndSend("springBoot.directExchange", "springBoot.queue", map);
        rabbitTemplate.convertAndSend("springBoot.fanoutExchange", "", new testBean("baozhou", "27"));
    }

    @Test
    public void contextLoads() {
        //新建交换器
        amqpAdmin.declareExchange(new DirectExchange("springBoot.directExchange"));
        amqpAdmin.declareExchange(new FanoutExchange("springBoot.fanoutExchange"));
        amqpAdmin.declareExchange(new TopicExchange("springBoot.topicExchange"));
        //新建队列
        amqpAdmin.declareQueue(new Queue("springBoot.queue", true));
        //绑定
        amqpAdmin.declareBinding(new Binding("springBoot.queue", Binding.DestinationType.QUEUE, "springBoot.fanoutExchange", "", null));
        amqpAdmin.declareBinding(new Binding("springBoot.queue", Binding.DestinationType.QUEUE, "springBoot.topicExchange", "springBoot.*", null));
        amqpAdmin.declareBinding(new Binding("springBoot.queue", Binding.DestinationType.QUEUE, "springBoot.directExchange", "", null));
    }

    @Test
    public void remove() {
        //移除交换器
        amqpAdmin.deleteExchange("springBoot.directExchange");
        amqpAdmin.deleteExchange("springBoot.fanoutExchange");
        amqpAdmin.deleteExchange("springBoot.topicExchange");
        //移除队列
        amqpAdmin.deleteQueue("springBoot.queue");
    }

    @Test
    public void receive() {
        Object bean = rabbitTemplate.receiveAndConvert("springBoot.queue");
        System.out.println("结果：" + bean);
    }
}
