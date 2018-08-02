package com.lind.microservice.productCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
  public int id;

  private int userId;

  private String userName;

  private int productId;

  private String productName;

  private int count;

  private double salePrice;

}
