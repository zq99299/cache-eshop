package cn.mrcode.cache.eshop.productserver.service;

import cn.mrcode.cache.eshop.productserver.model.ProductIntro;

public interface ProductIntroService {

    public void add(ProductIntro productIntro);

    public void update(ProductIntro productIntro);

    public void delete(Long id);

    public ProductIntro findById(Long id);

}
