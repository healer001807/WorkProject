package com.example.workproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 开启定时任务
@SpringBootApplication
public class WorkProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkProjectApplication.class, args);
    }

}
