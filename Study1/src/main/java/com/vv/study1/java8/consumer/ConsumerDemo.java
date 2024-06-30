package com.vv.study1.java8.consumer;

import java.util.function.Consumer;

/**
 * @author kw
 * @program WorkProject
 * @description consumer
 * @create 2024 - 01 - 21 11:36
 **/
public class ConsumerDemo {

    public static void accept(Integer integer) {
        Consumer<Integer> consumer = i -> i.compareTo(10);
        consumer.accept(integer);
    }

    public static void main(String[] args) {
        accept(100);
    }
}
