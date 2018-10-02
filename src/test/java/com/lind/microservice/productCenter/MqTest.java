package com.lind.microservice.productCenter;

import com.lind.microservice.productCenter.model.OrderInfo;
import com.lind.microservice.productCenter.mq.HelloPublisher;
import com.lind.microservice.productCenter.mq.OrderPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTest {
  @Autowired
  private HelloPublisher helloHelloPublisher;
  @Autowired
  private OrderPublisher orderPublisher;

  @Test
  public void hello() throws Exception {
    helloHelloPublisher.hello();
  }

  @Test
  public void order() throws Exception {
    orderPublisher.generateOrder(OrderInfo.builder().shippingName("zhangsan").build());
  }
}
