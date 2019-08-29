package cn.mrcode.cache.eshop.productserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.ProductSpecificationMapper;
import cn.mrcode.cache.eshop.productserver.model.ProductSpecification;
import cn.mrcode.cache.eshop.productserver.service.ProductSpecificationService;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Autowired
    private ProductSpecificationMapper productSpecificationMapper;

    public void add(ProductSpecification productSpecification) {
        productSpecificationMapper.add(productSpecification);
    }

    public void update(ProductSpecification productSpecification) {
        productSpecificationMapper.update(productSpecification);
    }

    public void delete(Long id) {
        productSpecificationMapper.delete(id);
    }

    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }

}
