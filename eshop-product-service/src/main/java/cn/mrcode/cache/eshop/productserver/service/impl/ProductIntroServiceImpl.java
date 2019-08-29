package cn.mrcode.cache.eshop.productserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.ProductIntroMapper;
import cn.mrcode.cache.eshop.productserver.model.ProductIntro;
import cn.mrcode.cache.eshop.productserver.service.ProductIntroService;

@Service
public class ProductIntroServiceImpl implements ProductIntroService {

    @Autowired
    private ProductIntroMapper productIntroMapper;

    public void add(ProductIntro productIntro) {
        productIntroMapper.add(productIntro);
    }

    public void update(ProductIntro productIntro) {
        productIntroMapper.update(productIntro);
    }

    public void delete(Long id) {
        productIntroMapper.delete(id);
    }

    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }

}
