package com.team4.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;
import com.team4.webapp.dto.ProductsDTO;
import com.team4.webapp.services.ProductServiceImpl;

@Controller
@RequestMapping("/shop")
public class ShopController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("")
	public String allPage(@RequestParam(name = "order",defaultValue = "desc") String order, Model model) {
		
		List<List<ProductsDTO>> lists;
		
		if(order.equals("desc") || order.equals("low") || order.equals("high")) {
			
			lists = productService.showAllProduct(order);
			
		}else {
			lists = productService.showAllProduct("desc");
			logger.info("실패");
		}
		model.addAttribute("lists", lists);
		
		for(List<ProductsDTO> sublist : lists) {
			for(ProductsDTO product : sublist) {
				logger.info(product.toString());
			}
		}
		return "shop/all";
	}
	

	
	

}
