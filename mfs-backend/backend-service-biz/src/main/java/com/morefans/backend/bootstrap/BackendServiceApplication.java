package com.morefans.backend.bootstrap;

import com.morefans.common.mybatis.common.mapper.BaseMapper;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@EnableAutoConfiguration
@MapperScan(basePackages = "com.morefans.backend.mapper",
		markerInterface= BaseMapper.class,nameGenerator= BeanNameGenerator.class)
public class BackendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendServiceApplication.class, args);
	}

}
