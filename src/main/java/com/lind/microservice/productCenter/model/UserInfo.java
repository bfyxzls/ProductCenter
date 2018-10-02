package com.lind.microservice.productCenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@ApiModel("用户")
public class UserInfo implements Serializable {
  @Id
  @GeneratedValue
  private int id;

  @ApiModelProperty("用户名")
  private String userName;

  @ApiModelProperty("电子邮件")
  private String email;

  @ApiModelProperty("电话")
  private String phone;

  @ApiModelProperty("性别")
  private Gander gander;

  @ApiModelProperty("婚否")
  @Column(name = "is_married")
  private boolean married;

  @ApiModelProperty("建立时间")
  private LocalDateTime createAt;

  public enum Gander {male, female}
}
