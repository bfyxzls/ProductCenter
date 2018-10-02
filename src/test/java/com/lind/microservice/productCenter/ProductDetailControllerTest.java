package com.lind.microservice.productCenter;

import com.lind.microservice.productCenter.model.ProductDetail;
import org.junit.Test;
import org.springframework.web.reactive.function.BodyInserters;

public class ProductDetailControllerTest extends BaseControllerTest {

  @Test
  public void add_success() {
    http.post()
        .uri("/products")
        .body(BodyInserters.fromObject(ProductDetail
            .builder()
            .shortDescription("电视")
            .discount(100)
            .longDescription("不错的电器")
            .productName("电视机")
            .inventory(100)
            .salePrice(4999)
            .basePrice(3000)
            .build()))
        .exchange()
        .expectStatus().isOk();
  }
}
