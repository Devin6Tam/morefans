package com.morefans.mfs_nacos_demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableAutoConfiguration
public class MfsNacosDemoProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MfsNacosDemoProviderApplication.class)
                .properties("spring.profiles=nacos").run(args);
    }

}
