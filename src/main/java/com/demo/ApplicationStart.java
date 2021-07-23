package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author admin
 * @Title: applicationStart
 * @ProjectName word
 * @Description: TODO
 * @date 2021/6/222:49
 */

@SpringBootApplication
@MapperScan("com.demo.mapper")
//@MapperScan(basePackages = {"com.demo.mapper"})
//@EnableNacosDiscovery
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class);
    }

}
