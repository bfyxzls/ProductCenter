package com.lind.microservice.productCenter.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lind.microservice.productCenter.model.OrderInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPublisher {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  /**
   * 生成订单后发送消息.
   */
  public void generateOrder(OrderInfo orderInfo) throws JsonProcessingException {
    rabbitTemplate.convertAndSend(
        AmqpConst.ORDER_GENERATE_ROUTEKEY,
        objectMapper.writeValueAsString(orderInfo)
    );
  }
}
