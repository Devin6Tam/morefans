package com.morefans.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 注册中心
 * @author tanxw
 */
@EnableEurekaServer
@SpringBootApplication
public class MfsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MfsEurekaServerApplication.class, args);
	}

}
