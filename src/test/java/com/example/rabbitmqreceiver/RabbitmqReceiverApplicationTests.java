package com.example.rabbitmqreceiver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.rabbitmqreceiver.controller.ReceiverMessageController;
import com.example.rabbitmqreceiver.domain.MessageLog;
import com.example.rabbitmqreceiver.domain.User;
import com.example.rabbitmqreceiver.repository.MessageLogRepository;
import com.example.rabbitmqreceiver.repository.UserRepository;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
class RabbitmqReceiverApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MessageLogRepository messageLogRepository;

  @Autowired
  private ReceiverMessageController receiverMessageController;

  @Test
  void contextLoads() {
  }

  @Test
  public void addTestMessageLog(){
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("MessageId".toUpperCase(),"shane");
    params.add("TenantID".toUpperCase(),"shane@money.com");
    params.add("ProcessStage".toUpperCase(),"shane");
    params.add("ProcessStageStatus".toUpperCase(),"shane");
    params.add("ExternalTransmission".toUpperCase(),"shane");
    params.add("InternalTransmission".toUpperCase(),"shane");
    params.add("SelfBillingDocument".toUpperCase(),"shane");
    params.add("MessageContent".toUpperCase(),"shane");
    String url = "https://kx-log.cfapps.sap.hana.ondemand.com/add";
    String ret = ReceiverMessageController.sendPostRequest(url,params);
    System.out.println("receiverDirectMessage: "+ ret);
  }

  @Test
  public void addTestUser(){
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("messageid","shane");
    params.add("tenantid","shane@money.com");
    String url = "https://kx-log.cfapps.sap.hana.ondemand.com/add";
    String ret = ReceiverMessageController.sendPostRequest(url,params);
    System.out.println("receiverDirectMessage: "+ ret);
  }

  @Test
  public void saveTest() throws Exception {
    User user = new User();
    user.setId(2L);
    user.setName("sst");
    user.setUrl("http://you.cn");
    user.setAge(9);
    userRepository.save(user);

    Assert.assertEquals(1, userRepository.findAll().size());
  }

  @Test
  public void saveTestMessage() throws Exception {
    MessageLog messageLog = new MessageLog();
    messageLog.setMessageId("1");
    messageLog.setExternalTransmission("4");
    messageLog.setInternalTransmission("2");
    messageLog.setMessageContent("3");
    messageLog.setProcessStage("5");
    messageLog.setProcessStageStatus("6");
    messageLog.setSelfBillingDocument("7");
    messageLog.setTenantID("8");
    messageLogRepository.save(messageLog);
    Assert.assertEquals(1, messageLogRepository.findAll().size());
  }

  @Test
  public void findTest(){
    System.out.println(userRepository.findAll());
  }
}
