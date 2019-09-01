package cn.mrcode.cache.eshop.productserver.service.impl;


import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.ProductMapper;
import cn.mrcode.cache.eshop.productserver.model.Product;
import cn.mrcode.cache.eshop.productserver.rabbitmq.ProductEvent;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQName;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQSender;
import cn.mrcode.cache.eshop.productserver.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RabbitMQSender rabbitMQSender;
    @Autowired
    private ProductMapper productMapper;

    public void add(Product product) {
        productMapper.add(product);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("add", "product", product.getId())));
    }

    public void update(Product product) {
        productMapper.update(product);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("update", "product", product.getId())));
    }

    public void delete(Long id) {
        productMapper.delete(id);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("delete", "product", id)));
    }

    public Product findById(Long id) {
        return productMapper.findById(id);
    }

}
