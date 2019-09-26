package cn.mrcode.cache.eshop.oneserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OneServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneServerApplication.class, args);
    }
}
