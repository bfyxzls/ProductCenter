package com.lind.microservice.productCenter.model;

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

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo extends EntityBase {
  @Id
  @GeneratedValue
  private int id;

  private int userId;

  private String userName;

  private double total;

  private String shippingName;

  private String shippingAddress;

  private Date orderTime;
}
