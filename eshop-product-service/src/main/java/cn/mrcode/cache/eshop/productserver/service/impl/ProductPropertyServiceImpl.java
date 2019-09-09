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
        ProductEvent productEvent = new ProductEvent("add", "product_property", productProperty.getId());
        productEvent.setProductId(productProperty.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(productEvent));
    }

    public void update(ProductProperty productProperty) {
        productPropertyMapper.update(productProperty);
        ProductEvent productEvent = new ProductEvent("update", "product_property", productProperty.getId());
        productEvent.setProductId(productProperty.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(productEvent));
    }

    public void delete(Long id) {
        ProductProperty productProperty = findById(id);
        productPropertyMapper.delete(id);
        ProductEvent productEvent = new ProductEvent("delete", "product_property", productProperty.getId());
        productEvent.setProductId(productProperty.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(productEvent));
    }

    public ProductProperty findById(Long id) {
        return productPropertyMapper.findById(id);
    }

    @Override
    public ProductProperty findByProductId(Long productId) {
        return productPropertyMapper.findByProductId(productId);
    }
}
