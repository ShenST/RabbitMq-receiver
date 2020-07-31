package com.example.rabbitmqreceiver.controller;

import com.example.rabbitmqreceiver.config.RabbitMqConfig;
import com.example.rabbitmqreceiver.domain.User;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {RabbitMqConfig.DirectQueue})
public class ReceiverDirectMessage {

//  @RabbitHandler
//  public void receiver(Map map){
//    System.out.println("receiverDirectMessage: "+map.toString());
//  }
//
//  @RabbitHandler
//  public void process(User user) {
//    System.out.println("Receiver object : " + user);
//  }
}
