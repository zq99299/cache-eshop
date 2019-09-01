package cn.mrcode.cache.eshop.productserver.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.ProductPropertyMapper;
import cn.mrcode.cache.eshop.productserver.model.ProductProperty;
import cn.mrcode.cache.eshop.productserver.rabbitmq.ProductEvent;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQName;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQSender;
import cn.mrcode.cache.eshop.productserver.service.ProductPropertyService;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Autowired
    private ProductPropertyMapper productPropertyMapper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    public void add(ProductProperty productProperty) {
        productPropertyMapper.add(productProperty);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("add", "property", productProperty.getId())));
    }

    public void update(ProductProperty productProperty) {
        productPropertyMapper.update(productProperty);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("update", "property", productProperty.getId())));
    }

    public void delete(Long id) {
        productPropertyMapper.delete(id);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("delete", "property", id)));
    }

    public ProductProperty findById(Long id) {
        return productPropertyMapper.findById(id);
    }

}
