package com.lind.microservice.productCenter.model;

import com.lind.microservice.productCenter.annotation.MinMoney;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.javamoney.moneta.Money;

/**
 * 产品实体.
 */
@Entity
@ToString
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商品")
public class ProductDetail {
  @Id
  @GeneratedValue
  private int id;

  @NotNull(message = "商品名称不能为空")
  @ApiModelProperty("商品名称")
  private String productName;

  @NotNull(message = "简介不能为空")
  @ApiModelProperty("简介")
  private String shortDescription;

  @NotNull(message = "描述不能为空")
  @ApiModelProperty("描述")
  private String longDescription;

  @Min(value = 0, message = "库存不能小于0")
  @ApiModelProperty("库存")
  private int inventory;

  @Min(value = 0, message = "价格不能小于0")
  @ApiModelProperty("销售价格")
  private double salePrice;

  @Min(value = 0, message = "底价不能小于0")
  @ApiModelProperty("底价")
  private double basePrice;

  @ApiModelProperty("打折")
  private int discount;
}