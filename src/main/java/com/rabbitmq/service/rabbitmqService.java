package com.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class rabbitmqService {

    @RabbitListener(queues = "name.news")
    public void getRabbitmq(Map map, Message message){
        System.out.println("消息接收成功======"+map);
        System.out.println("获取消息头:"+message.getBody());
        System.out.println("========"+message.getMessageProperties());
    }
}
