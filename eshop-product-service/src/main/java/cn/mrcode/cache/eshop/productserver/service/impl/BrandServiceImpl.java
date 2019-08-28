package cn.mrcode.cache.eshop.productserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.productserver.mapper.BrandMapper;
import cn.mrcode.cache.eshop.productserver.model.Brand;
import cn.mrcode.cache.eshop.productserver.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public void add(Brand brand) {
        brandMapper.add(brand);
    }

    public void update(Brand brand) {
        brandMapper.update(brand);
    }

    public void delete(Long id) {
        brandMapper.delete(id);
    }

    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }

}
