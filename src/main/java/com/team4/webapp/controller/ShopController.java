package com.team4.webapp.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	
		return "shop/all";
	}

	@GetMapping("/outer")
	public String OuterPage(String subcategory, @RequestParam(name = "order",defaultValue = "desc") String order, Model model) {

		String[] outer = {"Jacket", "Coat","Cardigan"};
		List<ProductsDTO> products = new ArrayList<ProductsDTO>();

		if(!(order.equals("desc") || order.equals("low") || order.equals("high"))) {
			order="desc";
		}
		if(subcategory == null) {
			for(String subcat : outer) {
				List<ProductsDTO> subProduct = productService.showProductList(subcat, order);
				for(ProductsDTO product : subProduct) {
					products.add(product);
				}
			}
			if(order.equals("high")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price).reversed())
						.collect(Collectors.toList());
				List<List<ProductsDTO>> subLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", subLists);	
				return "shop/all";
			}else if(order.equals("low")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price))
						.collect(Collectors.toList());
				List<List<ProductsDTO>> subLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", subLists);	
				return "shop/all";
			}

		}
		else if(subcategory.equals("Jacket")) {
			products = productService.showProductList(subcategory, order);
		} else if(subcategory.equals("Coat")) {
			products = productService.showProductList(subcategory, order);
		} else if(subcategory.equals("Cardigan")) {
			products = productService.showProductList(subcategory, order);
		}


		// 나중에 수정할 예정

		List<List<ProductsDTO>> subLists = Lists.partition(products, 4);
		model.addAttribute("lists", subLists);
		return "shop/all";
	}
	@GetMapping("/top")
	public String TopPage(String subcategory, @RequestParam(name = "order",defaultValue = "desc") String order, Model model) {

		String[] top = {"Knit", "Shirt","Tee"};
		List<ProductsDTO> products = new ArrayList<ProductsDTO>();

		if(!(order.equals("desc") || order.equals("low") || order.equals("high"))) {
			order="desc";
		}
		if(subcategory == null) {
			for(String subcat : top) {
				List<ProductsDTO> subProduct = productService.showProductList(subcat, order);
				for(ProductsDTO product : subProduct) {
					products.add(product);
				}
			}
			if(order.equals("high")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price).reversed())
						.collect(Collectors.toList());
				List<List<ProductsDTO>> subLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", subLists);	
				return "shop/all";
			}else if(order.equals("low")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price))
						.collect(Collectors.toList());
				List<List<ProductsDTO>> subLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", subLists);	
				return "shop/all";
			}
		}
		else if(subcategory.equals("Knit")) {
			products = productService.showProductList(subcategory, order);
		} else if(subcategory.equals("Shirt")) {
			products = productService.showProductList(subcategory, order);
		} else if(subcategory.equals("Tee")) {
			products = productService.showProductList(subcategory, order);
		}else {

		}
		List<List<ProductsDTO>> subLists = Lists.partition(products, 4);
		model.addAttribute("lists", subLists);
		return "shop/all";
	}
	@GetMapping("/bottom")
	public String BottomPage(String subcategory, @RequestParam(name = "order",defaultValue = "desc") String order, Model model) {

		String[] bottom = {"Pants", "Skirt"};
		List<ProductsDTO> products = new ArrayList<ProductsDTO>();

		if(!(order.equals("desc") || order.equals("low") || order.equals("high"))) {
			order="desc";
		}
		if(subcategory == null) {
			for(String subcat : bottom) {
				List<ProductsDTO> subProduct = productService.showProductList(subcat, order);
				for(ProductsDTO product : subProduct) {
					products.add(product);
				}
			}
			if(order.equals("high")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price).reversed())
						.collect(Collectors.toList());
				List<List<ProductsDTO>> subLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", subLists);	
				return "shop/all";
			}else if(order.equals("low")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price))
						.collect(Collectors.toList());
				List<List<ProductsDTO>> subLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", subLists);	
				return "shop/all";
			}
		}
		else if(subcategory.equals("Pants")) {
			products = productService.showProductList(subcategory, order);
		} else if(subcategory.equals("Skirt")) {
			products = productService.showProductList(subcategory, order);
		}else {

		}
		List<List<ProductsDTO>> subLists = Lists.partition(products, 4);
		model.addAttribute("lists", subLists);
		return "shop/all";
	}






}
