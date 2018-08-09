package com.lind.microservice.productCenter.model;

import com.lind.microservice.productCenter.annotation.MinMoney;
import com.lind.microservice.productCenter.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@ApiModel("订单")
public class OrderInfo {

  @Id
  @GeneratedValue
  private int id;

  @ApiModelProperty("用户编号")
  private int userId;

  @ApiModelProperty("用户名")
  private String userName;

  @ApiModelProperty("订单金额")
  private double total;

  @ApiModelProperty("收货人")
  private String shippingName;

  @ApiModelProperty("收货地址")
  private String shippingAddress;

  @ApiModelProperty("下单时间")
  private Date orderTime;

  @ApiModelProperty("订单状态")
  private OrderStatus orderStatus;
}
