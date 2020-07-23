package com.youhua.production;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.youhua.production.dao")
public class ProductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class, args);
    }

}
