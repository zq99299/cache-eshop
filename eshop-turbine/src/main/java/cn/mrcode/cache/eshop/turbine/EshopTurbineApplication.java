package cn.mrcode.cache.eshop.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class EshopTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopTurbineApplication.class, args);
    }
}
