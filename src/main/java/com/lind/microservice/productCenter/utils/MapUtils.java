package com.lind.microservice.productCenter.utils;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class MapUtils {
  public static <K, V> Map<K, V> singletonMap(Function<V, K> key, V value) {
    return Collections.singletonMap(key.apply(value), value);
  }

  public static <K, V> Map<K, V> ofEmpty(Map<K, V> map) {
    return Optional.ofNullable(map).orElse(Collections.emptyMap());
  }
}
