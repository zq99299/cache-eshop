package cn.mrcode.cache.eshop.productserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.productserver.model.Brand;
import cn.mrcode.cache.eshop.productserver.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/add")
    public String add(Brand brand) {
        try {
            brandService.add(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/update")
    public String update(Brand brand) {
        try {
            brandService.update(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        try {
            brandService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Brand findById(Long id) {
        try {
            return brandService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Brand();
    }

}
