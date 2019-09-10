package cn.mrcode.cache.eshop.productserver.service;

import java.util.List;

import cn.mrcode.cache.eshop.productserver.model.ProductProperty;

public interface ProductPropertyService {
	
	public void add(ProductProperty productProperty);
	
	public void update(ProductProperty productProperty);
	
	public void delete(Long id);
	
	public ProductProperty findById(Long id);

    List<ProductProperty> findByProductId(Long productId);
}
