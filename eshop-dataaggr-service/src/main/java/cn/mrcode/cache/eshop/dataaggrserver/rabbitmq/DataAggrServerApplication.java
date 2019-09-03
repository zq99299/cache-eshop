package cn.mrcode.cache.eshop.dataaggrserver.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DataAggrServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAggrServerApplication.class, args);
    }
}
