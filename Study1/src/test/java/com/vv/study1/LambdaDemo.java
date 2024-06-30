package com.vv.study1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 01 - 08 20:49
 **/
@SpringBootTest
public class LambdaDemo {

    @Test
    public void test() {

        List<String> list = new LinkedList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("David");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        list.sort(String::compareTo);

        Collections.sort(list, String::compareTo);

        // 有入参，无出参 consumer
        // 有入参，有出参 function
        // 无入参，无出参 runnable
        // 无入参，有出参 supplier
    }

    @Test
    public void test2() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        list.stream().filter(ele -> ele % 2 == 0).max(Integer::compareTo).ifPresent(System.out::println);

        //
        Optional<Integer> max = list.stream().parallel().filter(ele -> ele % 2 == 0).max(Integer::compareTo);
        if (max.isPresent()){
            System.out.println(max);
        }
    }

}
