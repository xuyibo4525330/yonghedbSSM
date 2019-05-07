package com.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/* spring会扫描service包下的所有类
 * 将类上带有@service注解的类,自动注册spring容器中,由spring创建该类的实例
 * */
@Service
public class DoorServiceImpl implements DoorService{
	//自动装备
	//由spring自动为属性赋值
	@Autowired
	DoorMapper mapper;
	
	@Override
	public List<Door> findAll() {
		List<Door> list = mapper.findAll();
		return list;
	}

	@Override
	public void deleteById(Integer id) {
		//根据Id删除门店信息
		mapper.deleteById(id);
	}

	@Override
	public int addDoor(Door door) {
		int rows = mapper.addDoor(door);
		return rows;
	}

	@Override
	public Door findById(Integer id) {
		Door door = mapper.findById(id);
		return door;
	}
	
	@Override
	public int updateById(Door door) {
		int rows = mapper.updateById(door);
		return rows;
	}
	
}
