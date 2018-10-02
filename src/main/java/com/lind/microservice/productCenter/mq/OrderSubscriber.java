package com.lind.microservice.productCenter.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lind.microservice.productCenter.model.OrderInfo;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderSubscriber {
  @Autowired
  ObjectMapper objectMapper;


  /**
   * 接收票据服务添加凭证消息.
   *
   * @param message voucherMessage.
   */
  @RabbitListener(queues =AmqpConfig.LIND_GENERATE_ORDER)
  public void receiveNoteCoreVoucherMessage(@Payload String message) throws IOException {
    OrderInfo orderInfoMessage = objectMapper.readValue(message, OrderInfo.class);
    log.debug("receive a generate order request", orderInfoMessage
    );
  }
}
