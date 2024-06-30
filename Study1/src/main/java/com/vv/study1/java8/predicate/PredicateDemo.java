package com.vv.study1.java8.predicate;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 12 - 18 21:17
 **/
public class PredicateDemo {
    /**
     * test:返回boolean值
     */
    public static boolean test(Integer num) {
        Predicate<Integer> predicate = integer -> integer > 10;
        return predicate.test(num);
    }

    /**
     * 两个条件都要满足
     *
     * @param num
     * @return
     */
    public static boolean and(Integer num) {
        Predicate<Integer> predicate = integer -> integer > 10;
        Predicate<Integer> and = predicate.and(integer -> integer < 20);
        return and.test(num);
    }

    /**
     * 两个条件满足其中之一
     *
     * @param num
     * @return
     */
    public static boolean or(Integer num) {
        Predicate<Integer> predicate = integer -> integer > 10;
        Predicate<Integer> or = predicate.or(integer -> integer < 15);
        return or.test(num);
    }

    /**
     * 返回boolean
     * 相反
     *
     * @param num
     * @return
     */
    public static boolean negate(Integer num) {
        Predicate<Integer> predicate = integer -> integer > 10;
        Predicate<Integer> negate = predicate.negate();
        return negate.test(num);
    }

    /**
     * 两个值是否相同/相等
     *
     * @param num
     * @return
     */
    public static boolean isEqual(Integer num) {
        Predicate<Integer> predicate = integer -> integer.equals(10);
        return predicate.test(num);
    }

    /**
     * 取反
     * true - false
     * false -true
     *
     * @param num
     * @return
     */
    public static boolean not(Integer num) {
        Predicate<Integer> predicate = integer -> integer > 10;
        Predicate<Integer> not = Predicate.not(predicate);
        return not.test(num);
    }

    public static void main(String[] args) {
        System.out.println(not(9));
    }
}
