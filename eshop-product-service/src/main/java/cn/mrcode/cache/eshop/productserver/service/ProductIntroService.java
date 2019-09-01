package cn.mrcode.cache.eshop.productserver.service;

import cn.mrcode.cache.eshop.productserver.model.ProductIntro;

public interface ProductIntroService {

    void add(ProductIntro productIntro);

    void update(ProductIntro productIntro);

    void delete(Long id);

    ProductIntro findById(Long id);

}
