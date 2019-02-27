package com.xiaoyu.demo.xiaoyu.unique.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.xiaoyu.demo.xiaoyu.unique.login")
@MapperScan(basePackages = "com.xiaoyu.demo.xiaoyu.unique.login.mapper")
public class XiaoyuUniqueLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoyuUniqueLoginApplication.class, args);
    }

}
