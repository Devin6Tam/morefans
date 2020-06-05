package com.morefans.activity;

import com.morefans.common.mybatis.common.mapper.BaseMapper;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动入口
 * @author tanxw
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@MapperScan(basePackages = "com.morefans.activity.mapper",
		markerInterface= BaseMapper.class,nameGenerator= BeanNameGenerator.class)
public class ActivityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityServiceApplication.class, args);
	}
}
