package cn.mrcode.cache.eshop.productserver.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.CategoryMapper;
import cn.mrcode.cache.eshop.productserver.model.Category;
import cn.mrcode.cache.eshop.productserver.rabbitmq.ProductEvent;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQName;
import cn.mrcode.cache.eshop.productserver.rabbitmq.RabbitMQSender;
import cn.mrcode.cache.eshop.productserver.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    public void add(Category category) {
        categoryMapper.add(category);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("add", "category", category.getId())));
    }

    public void update(Category category) {
        categoryMapper.update(category);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("update", "category", category.getId())));
    }

    public void delete(Long id) {
        categoryMapper.delete(id);
        rabbitMQSender.send(RabbitMQName.DATA_CHANGE_QUEUE, JSON.toJSONString(new ProductEvent("delete", "category", id)));
    }

    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }

}
