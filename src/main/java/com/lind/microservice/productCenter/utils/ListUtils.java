package com.lind.microservice.productCenter.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListUtils {

  /**
   * unzip.
   *
   * @param collections .
   * @param <T>         .
   * @return .
   */
  public static <T> List<T> unZip(List<List<T>> collections) {

    List<T> list = new ArrayList<>();
    if (collections != null) {
      for (Collection<T> item : collections) {
        if (item != null) {
          list.addAll(item);
        }
      }
    }
    return list;
  }
}
