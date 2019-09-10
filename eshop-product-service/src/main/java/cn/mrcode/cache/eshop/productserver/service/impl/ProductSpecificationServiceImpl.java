package cn.mrcode.cache.eshop.productserver.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        ProductEvent event = new ProductEvent("add", "product_specification", productSpecification.getId());
        event.setProductId(productSpecification.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(event));
    }

    public void update(ProductSpecification productSpecification) {
        productSpecificationMapper.update(productSpecification);
        ProductEvent event = new ProductEvent("update", "product_specification", productSpecification.getId());
        event.setProductId(productSpecification.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(event));
    }

    public void delete(Long id) {
        ProductSpecification productSpecification = findById(id);
        productSpecificationMapper.delete(id);
        ProductEvent event = new ProductEvent("delete", "product_specification", productSpecification.getId());
        event.setProductId(productSpecification.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(event));
    }

    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }

    @Override
    public List<ProductSpecification> findByProductId(Long productId) {
        return productSpecificationMapper.findByProductId(productId);
    }
}
