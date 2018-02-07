package com.situ.mall.service;

import java.util.List;

import com.situ.mall.bean.Product;
import com.situ.mall.common.ServerResponse;

public interface IProductService {

	ServerResponse<List<Product>> pageList(Integer page, Integer limit, Product product);

	ServerResponse deleteById(Integer id);

	ServerResponse deleteBatch(String ids);

}
