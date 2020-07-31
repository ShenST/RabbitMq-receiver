package com.example.rabbitmqreceiver.controller;

import com.example.rabbitmqreceiver.config.RabbitMqConfig;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMqConfig.FanoutQueueA)
public class ReceiverFanoutMessageA {

  @RabbitHandler
  public void processA(Map map){
    System.out.println("receiverFanoutMessageA:"+map.toString());
  }
}
