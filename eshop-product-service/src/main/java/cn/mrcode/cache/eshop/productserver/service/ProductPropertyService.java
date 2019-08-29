package cn.mrcode.cache.eshop.productserver.service;

import cn.mrcode.cache.eshop.productserver.model.ProductProperty;

public interface ProductPropertyService {
	
	public void add(ProductProperty productProperty);
	
	public void update(ProductProperty productProperty);
	
	public void delete(Long id);
	
	public ProductProperty findById(Long id);
	
}
