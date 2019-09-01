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
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("add", "intro", productIntro.getId())));
    }

    public void update(ProductIntro productIntro) {
        productIntroMapper.update(productIntro);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("update", "intro", productIntro.getId())));
    }

    public void delete(Long id) {
        productIntroMapper.delete(id);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("delete", "intro", id)));
    }

    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }

}
