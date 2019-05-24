package com.hit.minedays;

import com.hit.minedays.entity.GlobalValues;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinedaysApplication {

    static public GlobalValues gv = new GlobalValues();

    public static void main(String[] args) {
        SpringApplication.run(MinedaysApplication.class, args);
    }

}
