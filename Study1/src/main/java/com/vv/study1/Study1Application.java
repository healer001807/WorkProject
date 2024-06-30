package com.vv.study1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Study1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Study1Application.class, args);
    }


    @Override
    public void run(String... args) {
        System.out.println("initial");
    }
}
