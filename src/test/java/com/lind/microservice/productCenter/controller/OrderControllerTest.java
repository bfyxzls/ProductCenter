package com.lind.microservice.productCenter.controller;

import com.lind.microservice.productCenter.controller.BaseControllerTest;
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
