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
	public ServerResponse<List<Product>> pageList(Integer page, Integer limit) {

		return productService.pageList(page, limit);
	}

	@RequestMapping(value = "/productList")
	public String userList() {
		return "product_list";
	}

}
