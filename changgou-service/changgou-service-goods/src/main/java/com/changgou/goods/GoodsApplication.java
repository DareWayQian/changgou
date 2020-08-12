package com.changgou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
/*  @MapperScan是tk.mybatis.spring.annotation包下的，用于扫描Mapper接口 */
@MapperScan(basePackages = {"com.changgou.goods.dao"})
public class GoodsApplication {
    public static void main(String[] args) {
        System.out.println("");
        SpringApplication.run(GoodsApplication.class);
    }
}
