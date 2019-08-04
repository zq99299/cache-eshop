package cn.mrcode.cache.eshop.eshopeurelaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EshopEurelaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopEurelaClientApplication.class, args);
    }

    @Value("${server.port}")
    private int port;

    @RequestMapping("/")
    public String home() {
        return "Hello world port " + port;
    }

}
