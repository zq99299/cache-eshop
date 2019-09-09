package cn.mrcode.cache.eshop.datalinkrserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DataLinkServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataLinkServerApplication.class, args);
    }
}
