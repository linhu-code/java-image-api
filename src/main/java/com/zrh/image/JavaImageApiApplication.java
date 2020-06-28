package com.zrh.image;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.zrh.image.mapper"})
public class JavaImageApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaImageApiApplication.class, args);
    }

}
