package cn.mrcode.cache.eshop.inventoryserver.service;

import cn.mrcode.cache.eshop.inventoryserver.model.ProductInventory;

public interface ProductInventoryService {

    public void add(ProductInventory productInventory);

    public void update(ProductInventory productInventory);

    public void delete(Long id);

    public ProductInventory findById(Long id);

}
