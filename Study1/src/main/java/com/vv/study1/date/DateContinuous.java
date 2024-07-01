package com.vv.study1.date;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 日期连续判断
 * @create 2024 - 07 - 01 21:31
 **/
public class DateContinuous {

    /**
     * 连续几个月
     * 连续三个月，计算后值为2
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int yearMonthContinuous(LocalDate startDate, LocalDate endDate) {
        int monthValue = startDate.getMonthValue();
        int year = startDate.getYear();
        int monthValue1 = endDate.getMonthValue();
        int year1 = endDate.getYear();
        return (year1 - year) * 12 + (monthValue1 - monthValue);
    }

    /**
     * 年月是否连续
     * 日期数组
     * LocalDate[] dates = {
     * LocalDate.of(2024, 7, 1),
     * LocalDate.of(2024, 6, 1),
     * LocalDate.of(2024, 5, 2),
     * LocalDate.of(2024, 4, 1),
     * LocalDate.of(2024, 3, 1),
     * LocalDate.of(2024, 2, 1),
     * LocalDate.of(2024, 1, 1),
     * LocalDate.of(2023, 12, 1),
     * };
     * List<LocalDate> collect = Arrays.stream(dates).collect(Collectors.toList());
     * boolean b = calculation2(collect);
     * System.out.println(b);
     *
     * @param dateList
     * @return
     */
    public static boolean yearMonthContinuous1(List<LocalDate> dateList) {
        for (int i = 0; i < dateList.size(); i++) {
            if (i == dateList.size() - 1) {
                return true;
            }
            LocalDate localDate = dateList.get(i);
            if (localDate.plusMonths(-1).getMonthValue() != dateList.get(i + 1).getMonthValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean yearMonthContinuous2(List<LocalDate> dateList) {
        for (int i = 0; i < dateList.size() - 1; i++) {
            LocalDate localDate = dateList.get(i);
            if (localDate.plusMonths(-1).getMonthValue() != dateList.get(i + 1).getMonthValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 利用年月性质
     * <p>
     * YearMonth startMonth = YearMonth.of(2023, 12);
     * YearMonth endMonth = YearMonth.of(2024, 1);
     * boolean continuous = isContinuous(startMonth, endMonth);
     * System.out.println(continuous);  -- true
     *
     * @param startMonth
     * @param endMonth
     * @return
     */
    public static boolean yearMonthContinuous3(YearMonth startMonth, YearMonth endMonth) {
        if (startMonth.isAfter(endMonth)) {
            return false;
        }
        long months = ChronoUnit.MONTHS.between(startMonth, endMonth);
        return months == 1;
    }


//    public static void main(String[] args) {
//        YearMonth startMonth = YearMonth.of(2023, 12);
//        YearMonth endMonth = YearMonth.of(2024, 1);
//        boolean continuous = yearMonthContinuous3(startMonth, endMonth);
//        System.out.println(continuous);
//    }
}
