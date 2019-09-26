package cn.mrcode.cache.eshop.oneserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : zhuqiang
 * @date : 2019/9/26 21:30
 */
@FeignClient(value = "eshop-price-service")
public interface PriceService {
    @GetMapping("/product-price/findByProductId")
    String findByProductId(@RequestParam(value = "productId") Long productId);
}
