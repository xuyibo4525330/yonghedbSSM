package com.tedu.service;

import java.util.List;

import com.tedu.pojo.Order;

public interface OrderService {
	//查询全部订单
	public List<Order> findAll();
	//根据Id删除订单
	public int deleteById(Integer id);
	//添加订单信息
	public int orderAdd(Order order);
	//根据Id查询订单信息
	public Order findById(Integer id);
	//修改订单信息
	public int updateById(Order order);

}
