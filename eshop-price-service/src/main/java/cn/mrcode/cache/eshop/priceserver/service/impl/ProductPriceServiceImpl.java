package cn.mrcode.cache.eshop.priceserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.priceserver.mapper.ProductPriceMapper;
import cn.mrcode.cache.eshop.priceserver.model.ProductPrice;
import cn.mrcode.cache.eshop.priceserver.service.ProductPriceService;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	private ProductPriceMapper productPriceMapper;
	
	public void add(ProductPrice productPrice) {
		productPriceMapper.add(productPrice); 
	}

	public void update(ProductPrice productPrice) {
		productPriceMapper.update(productPrice); 
	}

	public void delete(Long id) {
		productPriceMapper.delete(id); 
	}

	public ProductPrice findById(Long id) {
		return productPriceMapper.findById(id);
	}

}
