package com.example.monstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
// https://brunch.co.kr/@springboot/530

@EnableCaching
@SpringBootApplication
public class MonstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonstudyApplication.class, args);
    }

}
