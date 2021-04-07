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
	@Autowired
	private ProductServiceImpl productService;

	/**
	 * 해당 상품 상세 페이지 클릭 시 상품상세페이지의 데이터 전달
	 * @param id = product_id
	 * @return "/product/product_details"
	 */
	@GetMapping("/{id}")
	public String productDetailPage(@PathVariable String id,Model model) {

		try {
			Long convertId = Long.valueOf(id);
			ProductDetailsDTO productDetailsDTO = productService.showProductDetail(convertId);
			model.addAttribute("product", productDetailsDTO);
			return "/product/product_details";
		} catch(NullPointerException e) {
			return "redirect:/";
		} catch(NumberFormatException e) {
			return "redirect:/";
		}
	}
}
