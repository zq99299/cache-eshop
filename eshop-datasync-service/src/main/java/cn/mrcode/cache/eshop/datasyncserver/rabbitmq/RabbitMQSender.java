package cn.mrcode.cache.eshop.datasyncserver.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : zhuqiang
 * @date : 2019/9/1 18:06
 */
@Component
public class RabbitMQSender {
    @Autowired
//    private AmqpTemplate amqpTemplate;
    private RabbitTemplate rabbitTemplate;

    public void send(String queue, String message) {
        this.rabbitTemplate.convertAndSend(queue, message);
    }
}
