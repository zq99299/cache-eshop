package cn.mrcode.cache.eshop.greetingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private EurelaClientService eurelaClientService;

    @RequestMapping("/")
    public String home() {
        return eurelaClientService.home("xx");
    }

    @FeignClient(name = "eshop-eurela-client")
    public interface EurelaClientService {
        @GetMapping("/")
        String home(@RequestParam(name = "name") String name);
    }

//    @Autowired
//    private RestTemplate restTemplate;

//    @RequestMapping("/")
//    public String home() {
//        String rest = restTemplate.getForObject("http://eshop-eurela-client", String.class);
//        return rest;
//    }
    // 在spring容器中注入一个bean，RestTemplate，作为rest服务接口调用的客户端
    // @LoadBalanced标注，代表对服务多个实例调用时开启负载均衡
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
