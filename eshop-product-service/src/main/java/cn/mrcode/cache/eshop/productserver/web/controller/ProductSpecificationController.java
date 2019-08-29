package cn.mrcode.cache.eshop.productserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.productserver.model.ProductSpecification;
import cn.mrcode.cache.eshop.productserver.service.ProductSpecificationService;

@RestController
@RequestMapping("/product-specification")
public class ProductSpecificationController {

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductSpecification productSpecification) {
        try {
            productSpecificationService.add(productSpecification);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductSpecification productSpecification) {
        try {
            productSpecificationService.update(productSpecification);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        try {
            productSpecificationService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ProductSpecification findById(Long id) {
        try {
            return productSpecificationService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductSpecification();
    }

}
