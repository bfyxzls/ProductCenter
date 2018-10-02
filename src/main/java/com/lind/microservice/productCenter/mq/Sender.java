package com.lind.microservice.productCenter.mq;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Sender {
  @Autowired
  AmqpTemplate rabbitTemplate;

  public void hello() {
    String context = "hello " + new Date();
    System.out.println("Sender : " + context);
    this.rabbitTemplate.convertAndSend("hello", context);
  }


}
