package com.lind.microservice.productCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableCaching
public class ProductCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductCenterApplication.class, args);
  }
}
