package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("/showSingleInfo")
	@ResponseBody
	public Product showSingleInfo(Integer id) {
		Product product = productService.showSingleInfo(id);
		return product;
	}

	@RequestMapping(value = "/productList")
	public String productList() {
		return "product_list";
	}

}
