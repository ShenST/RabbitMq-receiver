package com.example.rabbitmqreceiver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.rabbitmqreceiver.config.RabbitMqConfig;
import com.example.rabbitmqreceiver.domain.MessageLog;
import com.example.rabbitmqreceiver.repository.MessageLogRepository;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RabbitListener(queues = {RabbitMqConfig.DirectQueue})
public class ReceiverMessageController {

  @Autowired
  private MessageLogRepository messageLogRepository;

  @RabbitHandler
  public void receiver(String strJson){
    //MessageLog messageLog = JSON.parseObject(strJson, MessageLog.class);
    //messageLogRepository.save(messageLog);
    Map<String, String> paramMap = JSON.parseObject(strJson, new TypeReference<Map<String, String>>() {
    });
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    for (String key : paramMap.keySet()){
      params.add(key.toUpperCase(),paramMap.get(key));
      System.out.println("key:"+key);
    }
    String url = "https://kx-log.cfapps.sap.hana.ondemand.com/add";
    String ret = sendPostRequest(url,params);
    System.out.println("receive Direct Message(map):"+ params.toString());
    System.out.println("post result(entity):"+ret);
  }

  public static String sendPostRequest(String url, MultiValueMap<String, String> params){
    RestTemplate client = new RestTemplate();
    //新建Http头，add方法可以添加参数
    HttpHeaders headers = new HttpHeaders();
    //设置请求发送方式
    HttpMethod method = HttpMethod.POST;
    // 以表单的方式提交
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    //将请求头部和参数合成一个请求
    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
    //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
    ResponseEntity<String> response = client.exchange(url, method, requestEntity,String .class);

    return response.getBody();
  }

  //first letter to upper case
  public String toUpperCaseFirstOne(String s){
    if(Character.isUpperCase(s.charAt(0)))
      return s;
    else
      return Character.toUpperCase(s.charAt(0)) + s.substring(1);
  }
}