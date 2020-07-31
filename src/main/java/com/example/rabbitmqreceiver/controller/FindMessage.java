package com.example.rabbitmqreceiver.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.rabbitmqreceiver.domain.MessageLog;
import com.example.rabbitmqreceiver.repository.MessageLogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindMessage {

  @Autowired
  private MessageLogRepository messageLogRepository;

  @GetMapping("/find/{messageId}")
  public String FindMessageById(@PathVariable String messageId) {
    return JSONObject.toJSONString(messageLogRepository.findById(messageId));
  }

  @GetMapping("/find/all")
  public String FindMessage() {
    List<MessageLog> messageLogs = messageLogRepository.findAll().subList(0,3);
    return JSONObject.toJSONString(messageLogs);
  }
}
