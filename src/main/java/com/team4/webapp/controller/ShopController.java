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
	@Autowired
	private ProductServiceImpl productService;

	/**
	 * All을 클릭했을 때 상품 리스트 데이터 전달
	 * @param order= "desc", "high", "low"
	 * order가 null인 경우 기본 값 "desc"로 설정
	 * order 값이 "desc", "high", "low" 아닌 경우 "desc"로 설정
	 */
	@GetMapping("")
	public String allPage(@RequestParam(name = "order",defaultValue = "desc") String order, Model model) {

		List<List<ProductsDTO>> productLists;

		if(!(order.equals("desc") || order.equals("low") || order.equals("high"))) {
			order="desc";
		}
		productLists = productService.showAllProduct(order);
		model.addAttribute("lists", productLists);
		//사용자가 어느 카테고리에 들어왔는지를 보여주기 위해
		model.addAttribute("subcategory", "ALL");

		return "shop/all";
	}
	/**
	 * Outer 또는 Jacket, Coat, Cardigan를 클릭했을 때 상품 리스트 데이터 전달
	 * @param subcategory = "Jacket", "Coat", "Cardigan", null(메인카테고리 클릭 시) 
	 * @param order
	 * @return
	 */
	@GetMapping("/outer")
	public String OuterPage(String subcategory, @RequestParam(name = "order",defaultValue = "desc") String order, Model model) {

		String[] outer = {"Jacket", "Coat", "Cardigan"};

		return getProductsList("Outer", subcategory, order, model, outer);
	}
	/**
	 * Top 또는 Knit, Shirt, Tee를 클릭했을 때 상품 리스트 데이터 전달
	 * @param subcategory = "Knit", "Shirt", "Tee", null(메인카테고리 클릭 시) 
	 * @param order
	 * @return
	 */
	@GetMapping("/top")
	public String TopPage(String subcategory, @RequestParam(name = "order",defaultValue = "desc") String order, Model model) {

		String[] top = {"Knit", "Shirt","Tee"};

		return getProductsList("Top", subcategory, order, model, top);
	}
	/**
	 * Bottom 또는 Pants, Skirt를 클릭했을 때 상품 리스트 데이터 전달
	 * @param subcategory = "Pants", "Skirt", null(메인카테고리 클릭 시) 
	 * @param order
	 * @return
	 */
	@GetMapping("/bottom")
	public String BottomPage(String subcategory, @RequestParam(name = "order",defaultValue = "desc") String order, Model model) {

		String[] bottom = {"Pants", "Skirt"};

		return getProductsList("Bottom", subcategory, order, model, bottom);

	}
	/**
	 * 사용자가 클릭한 카테고리별로 상품 리스트를 가져오는 메소드
	 * @param maincategory : 사용자가 클릭한 메인카테고리
	 * @param subcategory : 사용자가 클릭한 서브카테고리
	 * @param order = "desc", "high", "low", 이외의 값은 "desc"로 설정
	 * @param subcatArr : maincategory에 해당하는 서브카테고리 배열 
	 * @return "shop/all"
	 */
	private String getProductsList(String maincategory, String subcategory, String order, Model model, String[] subcatArr) {

		List<ProductsDTO> products = new ArrayList<ProductsDTO>();

		if(!(order.equals("desc") || order.equals("low") || order.equals("high"))) {
			order="desc";
		}
		
		//메인카테고리를 클릭한 경우
		if(subcategory == null) {
			//클릭한 메인카테고리에 해당하는 서브카테고리의 상품들을 모두 가져와 products에 add
			for(String subcat : subcatArr) {
				List<ProductsDTO> subProduct = productService.showProductByCategory(subcat, order);
				for(ProductsDTO product : subProduct) {
					products.add(product);
				}
			}
			//화면에 "메인카테고리 > ALL"이라고 보여주기 위해
			model.addAttribute("subcategory", "ALL");
			//메인카테고리별로 가져온 상품들을 상품가격이 높은 순으로 정렬(stream 사용)
			if(order.equals("high")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price).reversed())
						.collect(Collectors.toList());
				List<List<ProductsDTO>> sortedProductLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", sortedProductLists);
				model.addAttribute("category", maincategory);
				model.addAttribute("subcategory", "ALL");
				return "shop/all";
			}
			//메인카테고리별로 가져온 상품들을 상품가격이 낮은 순으로 정렬(stream 사용)
			else if(order.equals("low")) {
				List<ProductsDTO> sortedList = products
						.stream()
						.sorted(Comparator.comparing(ProductsDTO::getProduct_price))
						.collect(Collectors.toList());
				List<List<ProductsDTO>> sortedProductLists = Lists.partition(sortedList, 4);
				model.addAttribute("lists", sortedProductLists);
				model.addAttribute("category", maincategory);
				model.addAttribute("subcategory", "ALL");
				return "shop/all";
			}
		}
		//서브카테고리를 클릭한 경우
		else {
			for(String subcat : subcatArr) {
				//subcategory가 올바른 카테고리이면 해당하는 order기준으로 정렬한 상품 리스트를 products로 가져옴
				if(subcat.equals(subcategory)) {
					products = productService.showProductByCategory(subcat, order);
					model.addAttribute("subcategory", subcat);
				}
			}
		}
		
		//한 row당 4개의 상품을 보여주기 위해 => productLists안에 하나의 리스트 당 상품 4개 담긴 리스트(구아바 라이브러리)
		List<List<ProductsDTO>> productLists = Lists.partition(products, 4);
		model.addAttribute("lists", productLists);
		model.addAttribute("category", maincategory);

		return "shop/all";
	}
}
