package cn.mrcode.cache.eshop.productserver.service;


import cn.mrcode.cache.eshop.productserver.model.Product;

public interface ProductService {

    void add(Product product);

    void update(Product product);

    void delete(Long id);

    Product findById(Long id);

}
