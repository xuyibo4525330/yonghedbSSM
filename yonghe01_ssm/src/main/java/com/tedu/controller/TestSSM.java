package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/*
 * 测试SSM整合后的开发环境
 */
@Controller //表示当前类是一个controller类
public class TestSSM {
	/*
	 * 	<1>自动装配
	 * 	该注解的作用是,由spring容器创建该对象
	 * 	并将创建的对象,赋值给该属性. 
	 */
	@Autowired
	DoorMapper mapper;
	/*
	 * 配置 请求资源路径(/hello)和方法(hello)
	 * 的映射关系
	 * 当请求访问(/hello)时,将会调用hello方法来处理请求
	 */
	@RequestMapping("/testSSM")
	public String hello() {
		System.out.println("Hello SSM 整合好了!!!!");
		
		//查询所有门店信息返回List<Door>集合
		List<Door> list = mapper.findAll();
		//遍历集合
		for (Door door : list) {
			System.out.println("ssm"+door);
		}
		
		//转向/WEB-INF/pages/test.jsp页面
		return "test";
	}
	
}
