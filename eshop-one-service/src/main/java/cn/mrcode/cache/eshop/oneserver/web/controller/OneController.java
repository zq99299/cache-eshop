package cn.mrcode.cache.eshop.oneserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.oneserver.service.InventoryService;
import cn.mrcode.cache.eshop.oneserver.service.PriceService;

/**
 * @author : zhuqiang
 * @date : 2019/9/26 21:39
 */
@RestController
@RequestMapping("/one")
public class OneController {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private PriceService priceService;

    @GetMapping("/inventory")
    public String findInventory(Long productId) {
        return inventoryService.findByProductId(productId);
    }

    @GetMapping("/price")
    public String findPrice(Long productId) {
        return priceService.findByProductId(productId);
    }
}
