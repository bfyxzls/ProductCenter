package com.lind.microservice.productCenter;

import org.junit.Test;

public class OrderControllerTest extends BaseControllerTest {

  @Test
  public void get() {
    http.get()
        .uri("/orders")
        .exchange()
        .expectStatus().isOk();
  }

}
