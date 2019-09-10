package cn.mrcode.cache.eshop.datalinkrserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eshop-product-service")
public interface EshopProductService {

    @GetMapping("/brand/findById")
    String findBrandById(@RequestParam(value = "id") Long id);

    @GetMapping("/category/findById")
    String findCategoryById(@RequestParam(value = "id") Long id);

    @GetMapping("/product-intro/findById")
    String findProductIntroById(@RequestParam(value = "id") Long id);

    @GetMapping("/product-property/findById")
    String findProductPropertyById(@RequestParam(value = "id") Long id);

    @GetMapping("/product/findById")
    String findProductById(@RequestParam(value = "id") Long id);

    @GetMapping("/product-specification/findById")
    String findProductSpecificationById(@RequestParam(value = "id") Long id);

    @GetMapping("/product-property/findByProductId")
    String findProductPropertyByProductId(@RequestParam(value = "productId") Long productId);

    @GetMapping("/product-specification/findByProductId")
    String findProductSpecificationByProductId(@RequestParam(value = "productId") Long productId);
}