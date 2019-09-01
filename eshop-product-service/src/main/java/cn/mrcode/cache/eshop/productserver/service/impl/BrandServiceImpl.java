package cn.mrcode.cache.eshop.productserver.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.BrandMapper;
import cn.mrcode.cache.eshop.productserver.model.Brand;
import cn.mrcode.cache.eshop.productserver.rabbitmq.ProductEvent;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQName;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQSender;
import cn.mrcode.cache.eshop.productserver.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    public void add(Brand brand) {
        brandMapper.add(brand);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("add", "brand", brand.getId())));
    }

    public void update(Brand brand) {
        brandMapper.update(brand);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("update", "brand", brand.getId())));
    }

    public void delete(Long id) {
        brandMapper.delete(id);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("delete", "brand", id)));
    }

    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }

}
