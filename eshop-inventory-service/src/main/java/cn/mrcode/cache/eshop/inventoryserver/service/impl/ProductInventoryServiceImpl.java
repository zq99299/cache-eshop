package cn.mrcode.cache.eshop.inventoryserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mrcode.cache.eshop.inventoryserver.mapper.ProductInventoryMapper;
import cn.mrcode.cache.eshop.inventoryserver.model.ProductInventory;
import cn.mrcode.cache.eshop.inventoryserver.service.ProductInventoryService;

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Autowired
    private ProductInventoryMapper productPriceMapper;

    public void add(ProductInventory productInventory) {
        productPriceMapper.add(productInventory);
    }

    public void update(ProductInventory productInventory) {
        productPriceMapper.update(productInventory);
    }

    public void delete(Long id) {
        productPriceMapper.delete(id);
    }

    public ProductInventory findById(Long id) {
        return productPriceMapper.findById(id);
    }

}
