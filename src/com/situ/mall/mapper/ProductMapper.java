package com.situ.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.mall.bean.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Product record);

	int insertSelective(Product record);

	Product selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Product record);

	int updateByPrimaryKey(Product record);

	List<Product> pageList(@Param("page") Integer page, @Param("limit") Integer limit);
}