package com.lind.microservice.productCenter.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = AmqpConfig.HELLO)
public class HelloSubscriber {
  @RabbitHandler
  public void process(String hello) {
    System.out.println("HelloSubscriber  : " + hello);
  }

}
