package com.lind.microservice.productCenter.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

public class YearMonthUtils {


  /**
   * yearMonth1 morethan yearMonth2.
   */
  public static boolean isAfter(YearMonth yearMonth1, YearMonth yearMonth2) {
    if (yearMonth1 == null || yearMonth2 == null) {
      return false;
    }
    return !yearMonth1.equals(yearMonth2) && yearMonth1.isAfter(yearMonth2);
  }

  /**
   * yearMonth1 less than or equal to yearmonth2.
   */
  public static boolean isBeforeOrEqual(YearMonth yearMonth1, YearMonth yearMonth2) {
    if (yearMonth1 == null || yearMonth2 == null) {
      return false;
    }

    return yearMonth1.equals(yearMonth2) || yearMonth1.isBefore(yearMonth2);
  }


  /**
   * from ~ to total months.
   *
   * @param begin 开始时间
   * @param end   结束时间
   * @return .
   */
  public static Set<YearMonth> closedMonthsBetween(YearMonth begin, YearMonth end) {
    Set<YearMonth> months = new HashSet<>();
    for (; begin.isBefore(end); begin = begin.plusMonths(1)) {
      months.add(begin);
    }
    months.add(end);
    return months;
  }

  /**
   * 上一年的当前一个季度的最后一个月.
   *
   * @param yearMonth .
   * @return .
   */
  public static YearMonth lastMonthOfPrevYearSameQuarter(
      final YearMonth yearMonth
  ) {
    return lastMonthOfCurrentQuarter(prevYear(yearMonth));
  }

  /**
   * 上一个季度的最后一个月.
   *
   * @param yearMonth .
   * @return .
   */
  public static YearMonth lastMonthOfPrevQuarter(
      final YearMonth yearMonth
  ) {
    return lastMonthOfCurrentQuarter(yearMonth)
        .plusMonths(-3);
  }

  /**
   * 当前季度的最后一个月.
   *
   * @param yearMonth .
   * @return .
   */
  public static YearMonth lastMonthOfCurrentQuarter(
      final YearMonth yearMonth
  ) {
    return YearMonth.of(
        yearMonth.getYear(),
        currentQuarter(yearMonth) * 3);
  }

  /**
   * 是否是季度的最后一个月.
   *
   * @param yearMonth .
   * @return .
   */
  public static Boolean isLastMonthOfCurrentQuarter(
      final YearMonth yearMonth
  ) {
    return yearMonth.getMonthValue() % 3 == 0;
  }

  /**
   * 是否是当前季度的第一个月.
   *
   * @param yearMonth .
   * @return
   */
  public static boolean isFirstMonthOfCurrentQuarter(
      final YearMonth yearMonth
  ) {
    int month = yearMonth.getMonthValue();
    return (month + 2) % 3 == 0;
  }


  /**
   * 前一个月份.
   *
   * @param yearMonth .
   * @return .
   */
  public static YearMonth prevMonth(
      final YearMonth yearMonth
  ) {
    return yearMonth.plusMonths(-1);
  }

  /**
   * 下一个月份.
   *
   * @param yearMonth .
   * @return .
   */
  public static YearMonth nextMonth(
      final YearMonth yearMonth
  ) {
    return yearMonth.plusMonths(1);
  }

  /**
   * 前一年.
   *
   * @param yearMonth .
   * @return .
   */
  public static YearMonth prevYear(
      final YearMonth yearMonth
  ) {
    return yearMonth.plusYears(-1);
  }

  /**
   * 前一年.
   *
   * @param yearMonth .
   * @return .
   */
  public static LocalDate lastDayOfMonth(
      final YearMonth yearMonth
  ) {
    YearMonth nextMonth = nextMonth(yearMonth);
    int year = nextMonth.getYear();
    int month = nextMonth.getMonthValue();
    return LocalDate.of(year, month, 1).plusDays(-1);
  }

  /**
   * 当前季度.
   *
   * @param yearMonth .
   * @return .
   */
  public static int currentQuarter(
      final YearMonth yearMonth
  ) {
    int month = yearMonth.getMonthValue();
    return (month + 2) / 3;
  }

  /**
   * 是否本月.
   *
   * @param yearMonth .
   * @return .
   */
  public static boolean isCurrentMonth(final YearMonth yearMonth) {
    return YearMonth.now().equals(yearMonth);
  }

  /**
   * 得到两个YearMonth之间的月数.
   *
   * @param startYearMonth 开始的时间
   * @param endYearMonth   结束的时间
   * @return .
   */
  public static int getMonths(
      final YearMonth startYearMonth,
      final YearMonth endYearMonth) {
    int startYear = startYearMonth.getYear();
    int startMonth = startYearMonth.getMonthValue();
    int endYear = endYearMonth.getYear();
    int endMonth = endYearMonth.getMonthValue();
    return (endYear - startYear) * 12 + endMonth - startMonth;
  }

}
