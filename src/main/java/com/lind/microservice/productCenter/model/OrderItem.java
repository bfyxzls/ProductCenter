package com.lind.microservice.productCenter.model;

import com.lind.microservice.productCenter.annotation.MinMoney;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.javamoney.moneta.Money;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("订单明细")
public class OrderItem {
  @Id
  @GeneratedValue
  private int id;

  @ApiModelProperty("主订单号")
  private int orderId;

  @ApiModelProperty("商品编号")
  private int productId;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("数量")
  private int count;

  @ApiModelProperty("购买价格")
  private double salePrice;
}
