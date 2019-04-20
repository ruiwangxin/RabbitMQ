package com.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createAmqpAdmin()
    {
        //创建交换器
//        amqpAdmin.declareExchange(new DirectExchange("DirectExchange.exchange"));
        //创建队列
//        amqpAdmin.declareQueue(new Queue("directqueue.news",true));
        /**
         * 创建绑定
         * destination:目地底
         * destinationType：绑定类型
         * exchange：交换器
         * routingKey：路邮件
         * arguments：参数
         */
        amqpAdmin.declareBinding(new Binding("directqueue.news",Binding.DestinationType.QUEUE
                ,"DirectExchange.exchange","direct.u",null));
    }


    @Test
    public void contextLoads() {
        Map map =new HashMap();
        map.put("1","aaaaaa");
        map.put("2",true);
        map.put("3",7);
        rabbitTemplate.convertAndSend("exchange.direct","name.news",map);
    }
    @Test
    public void getContextLoads()
    {
        Object o = rabbitTemplate.receiveAndConvert("name.news");
        System.out.println(o);
    }

}
