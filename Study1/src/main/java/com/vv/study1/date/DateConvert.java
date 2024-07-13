package com.vv.study1.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author kw
 * @program WorkProject
 * @description 日期转换
 * @create 2024 - 07 - 13 09:54
 **/
public class DateConvert {

    /**
     * date 转 LocalDateTime
     *
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneOffset.systemDefault()).toLocalDateTime();
    }

    /**
     * date 转 LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate();
    }

    /**
     * date 转 LocalTime
     *
     * @param date
     * @return
     */
    public static LocalTime dateToLocalTime(Date date) {
        return date.toInstant().atZone(ZoneOffset.systemDefault()).toLocalTime();
    }

    /**
     * date 格式化 字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneOffset.systemDefault()).toLocalDateTime();
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }


//    public static void main(String[] args) {
////        System.out.println(dateToLocalDateTime(new Date()));
////        System.out.println(dateToLocalDate(new Date()));
////        System.out.println(dateToLocalTime(new Date()));
//        System.out.println(dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
//    }

}
