package com.morefans.trade;

import com.morefans.common.mybatis.common.mapper.BaseMapper;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.morefans.trade.mapper",
		markerInterface= BaseMapper.class,nameGenerator= BeanNameGenerator.class)
public class TradeServiceBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeServiceBizApplication.class, args);
	}

}
