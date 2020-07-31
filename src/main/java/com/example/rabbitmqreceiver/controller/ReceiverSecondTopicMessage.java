package com.example.rabbitmqreceiver.controller;

import com.example.rabbitmqreceiver.config.RabbitMqConfig;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMqConfig.SecondTopicQueue)
public class ReceiverSecondTopicMessage {

  @RabbitHandler
  public void receiverSecondTopicMessage(Map map){
    System.out.println("receiverSecondTopicMessage:"+map.toString());
  }

}
