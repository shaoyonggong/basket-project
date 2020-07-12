package com.basket.basketproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 跳过spring security的认证
 * (exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
 * @author shaoyonggong
 */
@MapperScan("com.basket.basketproject.workservice.mapper")
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("***********启动成功*************");
    }

}
