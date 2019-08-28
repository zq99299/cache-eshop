package cn.mrcode.cache.eshop.productserver.service;


import cn.mrcode.cache.eshop.productserver.model.Brand;

public interface BrandService {

    void add(Brand brand);

    void update(Brand brand);

    void delete(Long id);

    Brand findById(Long id);

}
