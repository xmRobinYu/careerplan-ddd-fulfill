package com.ruyuan.fulfill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.ruyuan" })
@MapperScan("com.ruyuan.fulfill.infrastructure.gatewayimpl.database")
public class FulfillApplication {

    public static void main(String[] args) {
        SpringApplication.run(FulfillApplication.class, args);
    }

}
