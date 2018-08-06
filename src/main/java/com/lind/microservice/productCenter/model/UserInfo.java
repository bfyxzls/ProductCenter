package com.lind.microservice.productCenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class UserInfo {
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

  public enum Gander {male, female}
}
