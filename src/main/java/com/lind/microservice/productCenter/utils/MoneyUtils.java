package com.lind.microservice.productCenter.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.money.CurrencyUnit;
import org.javamoney.moneta.Money;

public class MoneyUtils {

  /**
   * 计算两个Money类型的和.
   *
   * @param money1 money1.
   * @param money2 money2.
   * @return .
   */
  public static Money add(Money money1, Money money2) {
    if (money1 == null) {
      return money2;
    }

    if (money2 == null) {
      return money1;
    }
    return money1.add(money2);
  }

  /**
   * 两个金额相减.
   *
   * @param money1 money1.
   * @param money2 money2.
   * @return .
   */
  public static Money subtract(Money money1, Money money2) {
    if (money1 == null && money2 == null) {
      return null;
    }
    CurrencyUnit currency = money1 != null ? money1.getCurrency() : money2.getCurrency();
    if (money1 == null) {
      money1 = Money.of(0, currency);
    }
    if (money2 == null) {
      money2 = Money.of(0, currency);
    }
    return money1.subtract(money2);
  }


  /**
   * 获取数值部分.
   *
   * @param money 金额.
   * @return .
   */
  public static Number getNumber(Money money) {
    if (money == null) {
      return null;
    }
    return money.getNumber();
  }

  /**
   * 取反.
   *
   * @param money .
   * @return
   */
  public static Money negate(Money money) {
    if (null == money) {
      return null;
    }
    return money.negate();
  }

  /**
   * zeroOf.
   *
   * @return
   */
  public static Money zeroOf(Money money) {
    if (null == money) {
      return null;
    }
    return Money.of(0, money.getCurrency());
  }

  /**
   * 由number和money的单位组成新的money.
   *
   * @return
   */
  public static Money of(String number, Money money) {
    if (null == money) {
      return null;
    }
    BigDecimal bigDecimal = new BigDecimal(number);
    return Money.of(bigDecimal, money.getCurrency());
  }

  /**
   * 大于0，如果null则返回false.
   *
   * @param money 需要比较的金额
   * @return
   */
  public static boolean isPositive(Money money) {
    if (money == null) {
      return false;
    }
    return money.isPositive();
  }

  /**
   * 获取值并保留两位小数.
   *
   * @param money 需要处理的参数
   * @return
   */
  public static String twoDecimalPlaces(Money money) {
    BigDecimal bigDecimal = BigDecimal.valueOf(money.getNumber().doubleValue());
    bigDecimal = bigDecimal.setScale(2);
    return String.valueOf(bigDecimal);
  }

  /**
   * 四舍五入.
   *
   * @param money  .
   * @param number .
   * @return
   */
  public static Money roundPlaces(Money money, int number) {
    BigDecimal bigDecimal = BigDecimal.valueOf(money.getNumber().doubleValue());
    bigDecimal = bigDecimal.setScale(number, RoundingMode.HALF_UP);
    return Money.of(bigDecimal, money.getCurrency());
  }
}

