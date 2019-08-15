package cn.mrcode.cache.eshop.eshopeurelaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableHystrixDashboard
@EnableCircuitBreaker
public class EshopEurelaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopEurelaClientApplication.class, args);
    }

    @Value("${server.port}")
    private int port;

    @RequestMapping("/")
    @HystrixCommand(fallbackMethod = "sayHello")
    public String home(String name) {
        if (name != null && name.equals("error")) {
            throw new RuntimeException("故意异常走降级机制");
        }
        return "Hello world port " + port;
    }

    public String sayHello(String name) {
        return "降级机制";
    }

}
