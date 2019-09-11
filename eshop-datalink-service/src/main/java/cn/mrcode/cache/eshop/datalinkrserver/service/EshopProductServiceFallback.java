package cn.mrcode.cache.eshop.datalinkrserver.service;

import org.springframework.stereotype.Component;

/**
 * @author : zhuqiang
 * @date : 2019/9/11 22:13
 */
@Component
public class EshopProductServiceFallback implements EshopProductService {
    @Override
    public String findBrandById(Long id) {
        return null;
    }

    @Override
    public String findCategoryById(Long id) {
        return null;
    }

    @Override
    public String findProductIntroById(Long id) {
        return null;
    }

    @Override
    public String findProductPropertyById(Long id) {
        return null;
    }

    @Override
    public String findProductById(Long id) {
        return null;
    }

    @Override
    public String findProductSpecificationById(Long id) {
        return null;
    }

    @Override
    public String findProductPropertyByProductId(Long productId) {
        return null;
    }

    @Override
    public String findProductSpecificationByProductId(Long productId) {
        return null;
    }
}
