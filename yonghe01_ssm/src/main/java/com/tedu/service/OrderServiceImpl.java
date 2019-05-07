package com.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.OrderDaoMapper;
import com.tedu.pojo.Order;

//@@service
/*作用1:标识他是一个service层
* 作用2:spring会自动扫描所有的service层,将所有的类添加到spring容器中
* (由spring容器创建实例)
* */
@Service 
public class OrderServiceImpl implements OrderService {
	//自动装备到spring容器
	@Autowired
	OrderDaoMapper orderDaoMapper;
	
	//查询全部订单信息
	@Override
	public List<Order> findAll() {
		List<Order> list = orderDaoMapper.findAll();
		return list;
	}
	
	//根据Id删除订单信息
	@Override
	public int deleteById(Integer id) {
		//调用orderMapper的orderById方法
			//根据Id删除信息
		int rows = orderDaoMapper.orderById(id);
		return rows;
	}
	
	//添加订单信息
	@Override
	public int orderAdd(Order order) {
		int rows = orderDaoMapper.orderAdd(order);
		return rows;
	}
	
	//根据Id查询订单信息
	@Override
	public Order findById(Integer id) {
		Order order = orderDaoMapper.findById(id);
		return order;
	}
	
	//修改订单信息
	@Override
	public int updateById(Order order) {
		int rows = orderDaoMapper.updateById(order);
		return rows;
	}
}
