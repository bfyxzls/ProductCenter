package com.lind.microservice.productCenter.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * amqp配置.
 */
@Configuration
public class AmqpConfig {
  @Bean
  public Queue helloQueue() {
    return new Queue("hello");
  }

}
