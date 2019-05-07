package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 测试springmvc开发环境
 */
@Controller //表示当前类是一个controller类
public class TestSpringmvc {
	
	/*
	 * 配置 请求资源路径(/hello)和方法(hello)
	 * 的映射关系
	 * 当请求访问(/hello)时,将会调用hello方法来处理请求
	 */
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("test springmvc");
		return "test";
	}
	
}
