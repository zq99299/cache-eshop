package cn.mrcode.cache.eshop.priceserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.priceserver.model.ProductPrice;
import cn.mrcode.cache.eshop.priceserver.service.ProductPriceService;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {

    @Autowired
    private ProductPriceService productPriceService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductPrice productPrice) {
        try {
            productPriceService.add(productPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductPrice productPrice) {
        try {
            productPriceService.update(productPrice);
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
            productPriceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ProductPrice findById(Long id) {
        try {
            return productPriceService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductPrice();
    }

    @RequestMapping("/findByProductId")
    @ResponseBody
    public ProductPrice findByProductId(Long productId) {
        try {
            return productPriceService.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductPrice();
    }
}
