package com.tedu.service;

import java.util.List;

import com.tedu.pojo.Door;

public interface DoorService {
	
	/*
	 * 查询所有门店信息
	 * List<Door>
	 */
	/*1.Mapper接口的全路径名必须要与mapper.xml文件的namespace保持一致
	 * 		mapper namespace="com.tedu.dao.DoorMapper"
	 * 2.mapper接口中方法的名字要与sql标签的id保持一致
	 * 3.mapper接口中方法的返回值类型和参数类型,要和sql标签的返回值类型以及参数类型保持一致
	 * */
	public List<Door> findAll();

	/*
	 * 2.根据ID删除门店信息
	 */
	public void deleteById(Integer id);
	
	/*
	 * 3.添加门店信息
	 */
	public int addDoor(Door door);
	
	/*
	 * 4.根据ID查询门店信息
	 */
	public Door findById(Integer id);

	public int updateById(Door door);
	
}
