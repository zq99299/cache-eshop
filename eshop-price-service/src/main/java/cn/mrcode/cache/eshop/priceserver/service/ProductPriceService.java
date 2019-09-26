package cn.mrcode.cache.eshop.priceserver.service;

import cn.mrcode.cache.eshop.priceserver.model.ProductPrice;

public interface ProductPriceService {

    public void add(ProductPrice productPrice);

    public void update(ProductPrice productPrice);

    public void delete(Long id);

    public ProductPrice findById(Long id);

    ProductPrice findByProductId(Long productId);
}
