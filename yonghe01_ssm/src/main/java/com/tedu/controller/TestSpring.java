package com.tedu.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.pojo.User;

/*
 * 测试spring开发环境
 */
public class TestSpring {
	public static void main(String[] args) {
		//1.读取spring的核心配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		//2.
		User u1 = (User) ac.getBean("user");
		//3.
		System.out.println(u1);
	}
}
