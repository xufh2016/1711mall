<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>商品列表</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
	
	</head>
	
	<body>
		<table class="layui-hide" id="datagrid"></table>
		
		<script>
			layui.use('table', function(){
			  var table = layui.table;
			  //第一个实例
			  table.render({
			    elem: '#datagrid',
			    height: 315,
			    cellMinWidth: 60,//全局定义常规单元格的最小宽度，layui 2.2.1 新增
			    url: '${ctx}/manager/product/pageList.action', //数据接口
			    page: true, //开启分页
			 	cols: [[ //表头
				    {field: 'id', title: 'ID',  sort: true, fixed: 'left'},
				    {field: 'categoryId', title: '库存编号'},
				    {field: 'name', title: '商品名称'} ,
				    {field: 'subtitle', title: '子标题', sort: true},
				    {field: 'detail', title: '商品详情' } ,
				    {field: 'price', title: '价格'},
				    {field: 'mainImage', title: '主图片'},
				    {field: 'stock', title: '库存',  sort: true},
				    {field: 'status', title: '商品状态',  sort: true},
				    {field: 'createTime', title: '创建时间', sort: true},
				    {field: 'updateTime', title: '更新时间',  sort: true}
			    ]]
			  });
			});
		</script>
	</body>

</html>
