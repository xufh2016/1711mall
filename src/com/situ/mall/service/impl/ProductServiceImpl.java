package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.mall.bean.Product;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.mapper.ProductMapper;
import com.situ.mall.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public ServerResponse<List<Product>> pageList(Integer page, Integer limit,Product product) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, limit);
		List<Product> list = productMapper.pageList(product);
		int totalCount = (int) ((Page) list).getTotal();
		return ServerResponse.createSuccess("执行成功", totalCount, list);
	}
	
	@Override
	public ServerResponse deleteById(Integer id) {
		// TODO Auto-generated method stub
		int i = productMapper.deleteByPrimaryKey(id);
		if (i>0)
			return ServerResponse.createSuccess("删除成功");
		return ServerResponse.createError("删除失败");
	}

	@Override
	public ServerResponse deleteBatch(String idstr) {
		// TODO Auto-generated method stub
		String[] ids = idstr.split(",");
		int count=productMapper.deleteBatch(ids);
		if(count==ids.length)
			return ServerResponse.createSuccess("删除成功");
		return ServerResponse.createError("删除失败");
	}
}
