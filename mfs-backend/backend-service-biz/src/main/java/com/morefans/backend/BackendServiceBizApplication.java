package com.morefans.backend;

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
public class BackendServiceBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendServiceBizApplication.class, args);
	}

}
