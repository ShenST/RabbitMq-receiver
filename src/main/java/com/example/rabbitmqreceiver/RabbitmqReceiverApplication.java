package com.example.rabbitmqreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RabbitmqReceiverApplication {

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqReceiverApplication.class, args);
  }

}
