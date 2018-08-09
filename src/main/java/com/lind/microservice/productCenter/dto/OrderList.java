package com.lind.microservice.productCenter.dto;

import com.lind.microservice.productCenter.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.javamoney.moneta.Money;

/**
 * DTO对象
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
  public int orderId;

  public int orderItemId;

  private int userId;

  private String userName;

  private int productId;

  private String productName;

  private int count;

  private double salePrice;

  private OrderStatus orderStatus;
}
