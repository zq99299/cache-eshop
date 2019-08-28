package cn.mrcode.cache.eshop.productserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.productserver.model.Product;
import cn.mrcode.cache.eshop.productserver.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/add")
    public String add(Product product) {
        try {
            productService.add(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    public String update(Product product) {
        try {
            productService.update(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        try {
            productService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    public Product findById(Long id) {
        try {
            return productService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Product();
    }
}
