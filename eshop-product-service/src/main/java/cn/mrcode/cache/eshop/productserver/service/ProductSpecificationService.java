package cn.mrcode.cache.eshop.productserver.service;

import cn.mrcode.cache.eshop.productserver.model.ProductSpecification;

public interface ProductSpecificationService {

    public void add(ProductSpecification productSpecification);

    public void update(ProductSpecification productSpecification);

    public void delete(Long id);

    public ProductSpecification findById(Long id);

    ProductSpecification findByProductId(Long productId);
}
