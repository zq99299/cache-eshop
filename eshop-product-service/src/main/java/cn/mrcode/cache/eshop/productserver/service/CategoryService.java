package cn.mrcode.cache.eshop.productserver.service;

import cn.mrcode.cache.eshop.productserver.model.Category;

public interface CategoryService {

    void add(Category category);

    void update(Category category);

    void delete(Long id);

    Category findById(Long id);

}
