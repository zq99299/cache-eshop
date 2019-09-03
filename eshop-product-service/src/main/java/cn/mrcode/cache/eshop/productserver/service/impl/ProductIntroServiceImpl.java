package cn.mrcode.cache.eshop.productserver.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.ProductIntroMapper;
import cn.mrcode.cache.eshop.productserver.model.ProductIntro;
import cn.mrcode.cache.eshop.productserver.rabbitmq.ProductEvent;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQName;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQSender;
import cn.mrcode.cache.eshop.productserver.service.ProductIntroService;

@Service
public class ProductIntroServiceImpl implements ProductIntroService {
    @Autowired
    private RabbitMQSender rabbitMQSender;
    @Autowired
    private ProductIntroMapper productIntroMapper;

    public void add(ProductIntro productIntro) {
        productIntroMapper.add(productIntro);
        ProductEvent event = new ProductEvent("add", "product_intro", productIntro.getId());
        event.setProductId(productIntro.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(event));
    }

    public void update(ProductIntro productIntro) {
        productIntroMapper.update(productIntro);
        ProductEvent event = new ProductEvent("update", "product_intro", productIntro.getId());
        event.setProductId(productIntro.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(event));
    }

    public void delete(Long id) {
        ProductIntro productIntro = findById(id);
        productIntroMapper.delete(id);
        ProductEvent event = new ProductEvent("delete", "product_intro", productIntro.getId());
        event.setProductId(productIntro.getProductId());
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(event));
    }

    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }

}
