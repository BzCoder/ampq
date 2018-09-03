package com.example.ampq.service;

import com.example.ampq.bean.testBean;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author BaoZhou
 * @date 2018/6/5
 */
@Service
public class amqpService {
    @RabbitListener(queues = "springBoot.queue")
    //2.自动创建队列 @RabbitListener(queuesToDeclare = {@Queue("myQueue"),@Queue("myQueue2")})
    //3.自动创建 Exchange与Queue绑定
    //@RabbitListener(bindings = @QueueBinding(
    //        value = @Queue("myQueue"),
    //        exchange = @Exchange("myExchange")
    //))
    public void recevie(testBean bean) {
        System.out.println("监听到消息了");
        System.out.println(bean);

    }
}
