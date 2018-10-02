package com.lind.microservice.productCenter.config;

import org.javamoney.moneta.Money;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.jackson.datatype.money.MoneyModule;

@Configuration
public class JacksonConfig {
  @Bean
  public MoneyModule moneyModule() {
    return new MoneyModule().withMonetaryAmount(Money::of);
  }
}