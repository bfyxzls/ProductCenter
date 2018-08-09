package com.lind.microservice.productCenter.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.javamoney.moneta.Money;

/**
 * min handle.
 */
public class MinMoneyHandle implements ConstraintValidator<MinMoney, Money> {
  MinMoney constraint;

  public void initialize(MinMoney constraint) {
    this.constraint = constraint;
  }

  /**
   * valid.
   *
   * @param value   .
   * @param context .
   * @return
   */
  public boolean isValid(Money value, ConstraintValidatorContext context) {
    return value != null && value.getNumber().doubleValue() >= constraint.value();
  }

}
