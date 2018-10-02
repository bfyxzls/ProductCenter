package com.lind.microservice.productCenter;

import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@ActiveProfiles("hazelcast-cache")
public class UserControllerTest extends BaseControllerTest {
  @Test
  public void fetchUsers() {
    getOk();
    //test caching
    getOk();
  }

  @Test
  public void modify_name() {
    http.put()
        .uri("/users/modify-name/1/zzl")
        .exchange()
        .expectStatus().isOk();
  }

  private WebTestClient.ResponseSpec getOk() {
    return http.get()
        .uri("/users/all/zzl")
        .exchange()
        .expectStatus().isOk();
  }


}
