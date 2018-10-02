package com.lind.microservice.productCenter;

import com.lind.microservice.productCenter.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTest {
  @Autowired
  private Sender helloSender;

  @Test
  public void hello() throws Exception {
    helloSender.hello();
  }
}
