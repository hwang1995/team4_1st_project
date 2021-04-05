package com.team4.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team4.webapp.dto.ProductDetailsDTO;
import com.team4.webapp.services.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("/{id}")
	public String productDetailPage(@PathVariable Long id,Model model) {

		try {
			ProductDetailsDTO productDetailsDTO = productService.productDetailPage(id);
			model.addAttribute("product", productDetailsDTO);
			return "/product/product_details";
		} catch(NullPointerException e) {
			return "redirect:/";
		}

		

		
	}
	

}
