package com.tedu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

@Controller
public class TestMybatis {
	
	@RequestMapping("/testDoorMapper")
	public String testDoorMapper() throws Exception {
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		//获取sqlSessionFactory工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//通过工厂对象创建session对象
		SqlSession session = factory.openSession();
		//获取DoorMapper接口的实例(通过反射获取DoorMapper对象)
		DoorMapper mapper = session.getMapper(DoorMapper.class);
		//通过DoorMapper接口对象调方法(findAll会根据对象的全路径名执行Sql)
		List<Door> list = mapper.findAll();
		//遍历所有门店信息
		for (Door door : list) {
			System.out.println(door);
		}
		return "test";
	}
}
