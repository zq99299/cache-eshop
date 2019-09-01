package cn.mrcode.cache.eshop.productserver.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.ProductSpecificationMapper;
import cn.mrcode.cache.eshop.productserver.model.ProductSpecification;
import cn.mrcode.cache.eshop.productserver.rabbitmq.ProductEvent;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQName;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQSender;
import cn.mrcode.cache.eshop.productserver.service.ProductSpecificationService;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {
    @Autowired
    private RabbitMQSender rabbitMQSender;
    @Autowired
    private ProductSpecificationMapper productSpecificationMapper;

    public void add(ProductSpecification productSpecification) {
        productSpecificationMapper.add(productSpecification);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("add", "specification", productSpecification.getId())));
    }

    public void update(ProductSpecification productSpecification) {
        productSpecificationMapper.update(productSpecification);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("update", "specification", productSpecification.getId())));
    }

    public void delete(Long id) {
        productSpecificationMapper.delete(id);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("delete", "specification", id)));
    }

    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }

}
