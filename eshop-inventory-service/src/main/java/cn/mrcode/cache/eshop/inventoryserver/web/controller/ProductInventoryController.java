package cn.mrcode.cache.eshop.inventoryserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.inventoryserver.model.ProductInventory;
import cn.mrcode.cache.eshop.inventoryserver.service.ProductInventoryService;

@RestController
@RequestMapping("/product-inventory")
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productPriceService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductInventory productInventory) {
        try {
            productPriceService.add(productInventory);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductInventory productInventory) {
        try {
            productPriceService.update(productInventory);
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
    public ProductInventory findById(Long id) {
        try {
            return productPriceService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductInventory();
    }

}
