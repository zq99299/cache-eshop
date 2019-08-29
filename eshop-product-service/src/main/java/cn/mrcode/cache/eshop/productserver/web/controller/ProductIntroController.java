package cn.mrcode.cache.eshop.productserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mrcode.cache.eshop.productserver.model.ProductIntro;
import cn.mrcode.cache.eshop.productserver.service.ProductIntroService;

@RestController
@RequestMapping("/product-intro")
public class ProductIntroController {

	@Autowired
	private ProductIntroService productIntroService;
	
	@RequestMapping("/add") 
	@ResponseBody
	public String add(ProductIntro productIntro) {
		try {
			productIntroService.add(productIntro);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/update") 
	@ResponseBody
	public String update(ProductIntro productIntro) {
		try {
			productIntroService.update(productIntro); 
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
			productIntroService.delete(id); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/findById") 
	@ResponseBody
	public ProductIntro findById(Long id){
		try {
			return productIntroService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ProductIntro();
	}
	
}
