package cn.mrcode.cache.eshop.productserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.productserver.model.Category;
import cn.mrcode.cache.eshop.productserver.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/add")
    public String add(Category category) {
        try {
            categoryService.add(category);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    public String update(Category category) {
        try {
            categoryService.update(category);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        try {
            categoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    public Category findById(Long id) {
        try {
            return categoryService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Category();
    }

}
