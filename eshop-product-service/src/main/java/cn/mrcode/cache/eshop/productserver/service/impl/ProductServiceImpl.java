package cn.mrcode.cache.eshop.productserver.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.ProductMapper;
import cn.mrcode.cache.eshop.productserver.model.Product;
import cn.mrcode.cache.eshop.productserver.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public void add(Product product) {
        productMapper.add(product);
    }

    public void update(Product product) {
        productMapper.update(product);
    }

    public void delete(Long id) {
        productMapper.delete(id);
    }

    public Product findById(Long id) {
        return productMapper.findById(id);
    }

}
