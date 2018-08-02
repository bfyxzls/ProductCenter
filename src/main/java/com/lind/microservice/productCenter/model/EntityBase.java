package com.lind.microservice.productCenter.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class EntityBase {
  @Id
  @GeneratedValue
  private int id;

  public int getId() {

    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
