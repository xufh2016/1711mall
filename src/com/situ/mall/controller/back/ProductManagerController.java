package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.bean.Product;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.service.IProductService;

@Controller
@RequestMapping(value = "/manager/product")
public class ProductManagerController {

	// 自动装在service
	@Autowired
	private IProductService productService;

	/**
	 * 分页显示
	 * 
	 * @return
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse<List<Product>> pageList(Integer page, Integer limit, Product product) {

		return productService.pageList(page, limit, product);
	}

	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return productService.deleteById(id);
	}

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public ServerResponse deleteBatch(String ids) {
		return productService.deleteBatch(ids);
	}

	// 点击编辑按钮后弹出页面
	@RequestMapping("/showSingleInfo")
	public String showSingleInfo(Integer id, Model model) {// id:商品Id
		Product product = productService.showSingleInfo(id);
		String secondCategoryName=productService.getSecondCategoryNameByProductId(id);
		String topCategoryName=productService.getTopCategoryNameByProductId(id);
		System.out.println(topCategoryName);
		System.out.println(secondCategoryName);
		model.addAttribute("product", product);
		model.addAttribute("secondCategoryName", secondCategoryName);
		model.addAttribute("topCategoryName", topCategoryName);
		return "product_edit";
	}

	// 展示商品信息
	@RequestMapping("/showProductInfo")
	public String showProductInfo(Integer id, Model model) {// id:商品Id
		Product product = productService.showSingleInfo(id);
		String secondCategoryName=productService.getSecondCategoryNameByProductId(id);
		String topCategoryName=productService.getTopCategoryNameByProductId(id);
		System.out.println(topCategoryName);
		System.out.println(secondCategoryName);
		model.addAttribute("product", product);
		model.addAttribute("secondCategoryName", secondCategoryName);
		model.addAttribute("topCategoryName", topCategoryName);
		return "product_info";
	}

	// 跳转到商品列表页
	@RequestMapping(value = "/productList")
	public String productList() {
		return "product_list";
	}

	// 跳转到添加商品页
	@RequestMapping(value = "/getAddPage")
	public String getAddPage() {
		return "product_add";
	}
 
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(Product product) {
		return productService.add(product);
	}
	
	@RequestMapping("/updateProductById")
	@ResponseBody
	public ServerResponse updateProductById(Product product) {
		System.out.println("ProductManagerController.updateProductById()");
		return productService.updateProductById(product);
	}

}
