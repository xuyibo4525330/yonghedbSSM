package com.tedu.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.pojo.Order;
import com.tedu.service.DoorService;
import com.tedu.service.OrderService;


//@@Controller
/*作用1:标识他是一个Controller层
 * 作用2:spring会自动扫描所有的Controller层,将所有的类添加到spring容器中
 * (由spring容器创建实例)
 * */
@Controller
public class OrderController {
	
	@Autowired //由spring创建实例并为变量赋值
	OrderService orderService;
	@Autowired
	DoorService doorService;
	
	/*1.查询所有订单信息*/
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		//1.调用orderService层的findAll方法查询所有订单
		List<Order> list = orderService.findAll();
		for (Order order : list) {
			System.out.println(order);
		}
		//用Model封装供页面使用
		model.addAttribute("list",list);
		//转向订单列表页面
		return "order_list";
	}
	
	/*2.根据Id删除订单信息*/
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		//1.调用orderService的deleteById方法
			//根据id删除订单信息
		int rows = orderService.deleteById(id);
		System.out.println("删除"+rows+"条信息");
		//删除完转向查询所有订单的方法
		return "redirect:/orderList";
	}
	//3.查询所有门店并跳转到订单新增页面
	@RequestMapping("/findAllDoorToOrder_add")
	public String toOrder_Add(Model model) {
		//1.直接调doorService的findAll方法查询所有门店信息
		List<Door> list = doorService.findAll();
		//将list放到model中
		model.addAttribute("list", list);
		//查询到所有门店信息后回显到添加页面
		return "order_add";
	}
	
	//3.添加订单信息
	@RequestMapping("/orderAdd")
	public String orderAdd(Order order) {
		System.out.println(order);
		int rows = orderService.orderAdd(order);
		System.out.println("添加"+rows+"行数据");
		//添加完毕后转向到查询所有订单信息
		return "redirect:/orderList";
	}
	
	//4.1根据Id查询订单信息
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer id,Model model) {
		//1.调用orderService+findById方法,根据Id查询订单信息
		Order order = orderService.findById(id);
		System.out.println(order);
		//将订单信息存入model中
		model.addAttribute("order", order);
		//1.调用doorService+findAll方法,查询所有门店信息
		List<Door> list = doorService.findAll();
		System.out.println(list);
		//将所有门店信息存入model中
		model.addAttribute("list", list);
		return "order_update";
	}
	
	//4.2根据Id修改订单信息
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order) {
		System.out.println("================"+order.getPnum()+"==============");
		//1,调用orderService的updatById方法
		int rows = orderService.updateById(order);
		System.out.println("修改"+rows+"行数据");
		//转向查询所有订单的方法
		return "redirect:/orderList";
	}
	
	/* 自定义日期转换格式 
	@InitBinder
	public void InitBinder (ServletRequestDataBinder binder){
		binder.registerCustomEditor(java.util.Date.class, 
			new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)
		);
	}*/
	/* 自定义日期转换格式 */
	@InitBinder
	public void InitBinder (ServletRequestDataBinder binder){
		binder.registerCustomEditor(java.util.Date.class, 
			new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)
		);
	}
	
	
}
