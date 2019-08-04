package com.mrcode.cache.eshop.eshopeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EshopEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopEurekaServerApplication.class, args);
    }

}
