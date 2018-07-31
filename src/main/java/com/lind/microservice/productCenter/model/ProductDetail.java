package com.lind.microservice.productCenter.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductDetail implements Serializable {
  @Id
  @GeneratedValue
  private int productId;
  private String productName;
  private String shortDescription;
  private String longDescription;
  private String inventoryId;

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }
}