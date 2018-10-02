package com.lind.microservice.productCenter.mq;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloPublisher {
  @Autowired
  AmqpTemplate rabbitTemplate;
  @Autowired
  AmqpConfig amqpConfig;

  public void hello() {
    String context = "hello " + new Date();
    System.out.println("HelloPublisher : " + context);

    this.rabbitTemplate.convertAndSend(AmqpConfig.EXCHANGE, AmqpConfig.HELLO, context);
  }


}
