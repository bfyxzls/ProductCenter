package com.lind.microservice.productCenter.controller;

import java.time.Duration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class BaseControllerTest {
  @Autowired
  protected WebTestClient http;

  /**
   * action 执行前运行 .
   */
  @Before
  public void before() {
    http = http.mutate()
        .responseTimeout(Duration.ofMillis(300000))
        .build();
  }

}
