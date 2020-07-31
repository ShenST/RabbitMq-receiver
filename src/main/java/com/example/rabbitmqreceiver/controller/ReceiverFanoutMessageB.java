package com.example.rabbitmqreceiver.controller;

import com.example.rabbitmqreceiver.config.RabbitMqConfig;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMqConfig.FanoutQueueB)
public class ReceiverFanoutMessageB {

  @RabbitHandler
  public void processB(Map map){
    System.out.println("receiverFanoutMessageB:"+map.toString());
  }
}
