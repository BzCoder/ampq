package com.example.ampq.service;

import com.example.ampq.bean.testBean;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author BaoZhou
 * @date 2018/6/5
 */
@Service
public class amqpService {
    @RabbitListener(queues = "springBoot.queue")
    public void recevie(testBean bean) {
        System.out.println("监听到消息了");
        System.out.println(bean);

    }
}
