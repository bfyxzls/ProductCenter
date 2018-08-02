package com.lind.microservice.productCenter.model;

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
public class UserInfo extends EntityBase {
  @Id
  @GeneratedValue
  private int id;

  private String userName;

  private String email;

  private String phone;

  private Gander gander;

  public enum Gander {male, female}
}
