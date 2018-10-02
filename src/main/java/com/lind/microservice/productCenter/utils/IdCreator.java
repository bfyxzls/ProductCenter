package com.lind.microservice.productCenter.utils;

import org.bson.types.ObjectId;

/**
 * id 创建者.
 */
public class IdCreator {

  /** 创建一个id.
   * @return id.
   */
  public static String newId() {
    return new ObjectId().toString();
  }
}
