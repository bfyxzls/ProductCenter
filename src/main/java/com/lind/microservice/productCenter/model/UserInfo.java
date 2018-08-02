package com.lind.microservice.productCenter.model;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserInfo extends EntityBase {
  private String name;
  private String email;
  private String phone;
  private Gander gander;

  private enum Gander {male, female}
}
