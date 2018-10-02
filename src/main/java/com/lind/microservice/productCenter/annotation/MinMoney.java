package com.lind.microservice.productCenter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 最小值约束.
 */
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinMoneyHandle.class)
public @interface MinMoney {
  /**
   * message.
   *
   * @return
   */
  String message() default "minMoney fail";

  /**
   * min value.
   *
   * @return
   */
  double value() default 0;

  /**
   * group.
   *
   * @return
   */
  Class<?>[] groups() default {};

  /**
   * payload.
   *
   * @return
   */
  Class<? extends Payload>[] payload() default {};
}