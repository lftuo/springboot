package com.example.springboot;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 扫描mybatis mapper包
@MapperScan(basePackages = "com.example.springboot.mapper")
// 扫描所有需要的包，包含一些自用的工具类包所在路径
@ComponentScan(basePackages = {"com.example.springboot","org.n3r.idworker"})
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
