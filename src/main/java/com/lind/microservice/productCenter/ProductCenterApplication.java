package com.lind.microservice.productCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ProductCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductCenterApplication.class, args);
  }
}
