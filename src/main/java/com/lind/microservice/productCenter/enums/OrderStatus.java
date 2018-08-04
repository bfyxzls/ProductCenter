package com.lind.microservice.productCenter.enums;

public enum OrderStatus {
  NOPAY("待付款"),
  PAID("已付款"),
  SENT("已发货"),
  SHIPPING("运输中"),
  RECEIVED("已收货"),
  FINISHED("已完成"),
  CLOSED("已关闭");
  private String desc;//中文描述

  OrderStatus(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return desc;
  }
}
