package com.lind.microservice.productCenter;

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

  private WebTestClient.ResponseSpec getOk() {
    return http.get()
        .uri("/users/all/zzl")
        .exchange()
        .expectStatus().isOk();
  }
}
