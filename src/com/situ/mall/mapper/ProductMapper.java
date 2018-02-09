package com.situ.mall.mapper;

import java.util.List;

import com.situ.mall.bean.Product;
import com.situ.mall.common.ServerResponse;

public interface ProductMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Product record);

	int insertSelective(Product record);

	Product selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Product record);

	int updateByPrimaryKey(Product record);

	List<Product> pageList(Product product);

	int  deleteBatch(String[] ids);

	ServerResponse<Product> showSingleInfo(Integer id);
}