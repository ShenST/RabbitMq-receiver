package com.example.rabbitmqreceiver.controller;

import com.example.rabbitmqreceiver.config.RabbitMqConfig;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMqConfig.FirstTopicQueue)
public class ReceiverFirstTopicMessage {

  @RabbitHandler
  public void receiverFirstTopicMessage(Map map){
    System.out.println("receiverFirstTopicMessage:"+map.toString());
  }

}
