package cn.mrcode.cache.eshop.priceserver.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.priceserver.mapper.ProductPriceMapper;
import cn.mrcode.cache.eshop.priceserver.model.ProductPrice;
import cn.mrcode.cache.eshop.priceserver.service.ProductPriceService;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Autowired
    private ProductPriceMapper productPriceMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void add(ProductPrice productPrice) {
        productPriceMapper.add(productPrice);
        redisTemplate.opsForValue().set("product_price_" + productPrice.getId(), JSON.toJSONString(productPrice));
    }

    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
        redisTemplate.opsForValue().set("product_price_" + productPrice.getId(), JSON.toJSONString(productPrice));
    }

    public void delete(Long id) {
        productPriceMapper.delete(id);
        redisTemplate.delete("product_price_" + id);
    }

    public ProductPrice findById(Long id) {
        return productPriceMapper.findById(id);
    }

}
