package com.morefans.mfs_nacos_demo_client;

import com.morefans.mfs_nacos_demo.service.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
public class MfsNacosDemoClientApplication {

    @Reference
    private EchoService echoService;

    @GetMapping("/echo")
    public String echo(String message) {
        return echoService.echo(message);
    }

    public static void main(String[] args) {
        SpringApplication.run(MfsNacosDemoClientApplication.class, args);
    }

}
