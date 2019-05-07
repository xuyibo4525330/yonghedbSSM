package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Order;

public interface OrderDaoMapper {
	//查询全部订单
	public List<Order> findAll();
	//根据ID删除订单信息
	public int orderById(Integer id);
	//添加订单信息
	public int orderAdd(Order order);
	//根据Id查询订单信息
	public Order findById(Integer id);
	//修改订单信息
	public int updateById(Order order);
	
}
