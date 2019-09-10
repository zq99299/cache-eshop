package cn.mrcode.cache.eshop.datalinkrserver.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.datalinkrserver.service.EshopProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private EshopProductService eshopProductService;

    @RequestMapping("/{id}")
    public String get(@PathVariable Long id) {
        // 先从本地缓存获取，这里就不写了
        // 再从 redis 主机群获取，获取逻辑参考数据聚合服务中的商品维度

        Long productId = id;
        String dimProductKey = "dim_product_" + productId;
        String dimProductJsonStr = redisTemplate.opsForValue().get(dimProductKey);
        // 如果商品聚合服务放入的 商品聚合信息没有在主机群查询到，那么就说明要么没有这个商品，要么就是过期了
        if (StringUtils.isBlank(dimProductJsonStr)) {
            // 需要访问原始服务之间获取数据，按照数据聚合服务的聚合逻辑聚合起来
            String productJsonStr = eshopProductService.findProductById(productId);
			if (StringUtils.isBlank(productJsonStr)) {
				// 没有这个商品信息
                return null;
            }
            // 否则继续获取其他维度数据
            JSONObject product = JSON.parseObject(productJsonStr);
            // 这里需要在商品服务中增加按 productId 查询的接口
            String productPropertyJsonStr = eshopProductService.findProductPropertyByProductId(productId);
            if (StringUtils.isNotBlank(productPropertyJsonStr)) {
                product.put("productProperty", JSON.parseArray(productPropertyJsonStr));
            }
            String productSpecificationJsonStr = eshopProductService.findProductSpecificationByProductId(productId);
            if (StringUtils.isNotBlank(productSpecificationJsonStr)) {
                product.put("productSpecification", JSON.parseArray(productSpecificationJsonStr));
            }
            dimProductJsonStr = product.toJSONString();
            redisTemplate.opsForValue().set(dimProductKey, dimProductJsonStr);
        }
        return dimProductJsonStr;
    }

}
