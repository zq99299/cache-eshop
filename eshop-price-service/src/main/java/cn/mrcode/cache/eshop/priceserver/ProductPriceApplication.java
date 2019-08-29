package cn.mrcode.cache.eshop.priceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "cn.mrcode.cache.eshop.userserver.mappter")
public class ProductPriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductPriceApplication.class, args);
    }
}
