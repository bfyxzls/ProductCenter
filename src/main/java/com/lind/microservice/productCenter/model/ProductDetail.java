package com.lind.microservice.productCenter.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class ProductDetail implements Serializable {
  @Id
  @GeneratedValue
  private int productId;
  @NotNull(message = "产品名称不能为空")
  private String productName;
  private String shortDescription;
  private String longDescription;
  private String inventoryId;
}