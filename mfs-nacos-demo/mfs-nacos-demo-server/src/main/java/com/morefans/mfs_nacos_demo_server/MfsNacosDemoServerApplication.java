package com.morefans.mfs_nacos_demo_server;

import com.morefans.mfs_nacos_demo.service.EchoService;
import org.springframework.boot.SpringApplication;
import org.apache.dubbo.config.annotation.Service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableAutoConfiguration
public class MfsNacosDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfsNacosDemoServerApplication.class, args);
    }

}

@Service
class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        return "[echo] Hello, " + message;
    }

}
