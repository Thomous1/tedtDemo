package com.bonc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by  on 2018/5/23.
 */
@SpringBootApplication
@EnableScheduling
public class AppDemo {
    public static void main(String[] args) {
        SpringApplication.run(AppDemo.class);
    }
}
