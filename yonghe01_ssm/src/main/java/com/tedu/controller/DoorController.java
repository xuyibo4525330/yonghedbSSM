package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.service.DoorService;

/* spring会扫描Controller包下的所有类
 * 将类上带有@Controller注解的类,自动注册spring容器中,由spring创建该类的实例
 * */
@Controller
public class DoorController {
	//自动装备
	//由spring自动为属性赋值
	@Autowired
	DoorService doorService;
	
	//1.查询所有门店信息
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		List<Door> list = doorService.findAll();

		//往Model添加一个属性(添加到request域中,从而页面从域中获取数据)
		model.addAttribute("list",list);
		//转向test.jsp页面,同时会将存入Model中的list集合带到test.jsp页面
		System.out.println(model.addAttribute("list",list));
		return "door_list";
	}
	
	//2.添加门店
	@RequestMapping("/doorAdd")
	public String doorAdd(Door door) {//可以用对象来接收页面传来的值,也可以有属性类型接收
//		System.out.println(door);
		//调用DoorService层中的adDoor方法,添加门店信息
		int rows = doorService.addDoor(door);
		
		return "redirect:/doorList";
	}
	
	//3.根据ID查询门店信息,先根据ID查询当前门店的信息,把查询到的门店信息回显到页面
	@RequestMapping("/doorInfo")
	public String doorIndo(Integer id,Model model) {
		//1.根据ID查询门店信息
		Door door = doorService.findById(id);
		System.out.println("=================="+id+"============");
		//2.将查询到的门店信息存入model中(存入request域中)
		model.addAttribute("door",door);
		//点击修改门店将查询到的数据回显到door_update页面
		return "door_update";
	}
	
	//4.根据ID修改当前门店信息
	//1)先根据Id查询门店信息
	//2)再根据ID修改门店信息
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door) {
//		System.out.println("door");
		//1.调用doorService的updateById方法修改门店信息
		int rows = doorService.updateById(door);
		System.out.println("=========修改成功!!!=======");
		//2.转向查询所有门店方法
		return "redirect:/doorList";
	}
	
	/*
	 * 通用的页面跳转方法(先是找方法名 如果能匹配上就执行方法,皮配不上就执行通用方法)
	 */
	@RequestMapping("/{page}")
	public String page(@PathVariable String page){//这个注解为了让上面的变量赋值给这个page参数
		return page;
	}

	/*
	 * 根据ID删除门店信息
	 */
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id) {
		//调用deleteById方法,根据Id删除门店
		doorService.deleteById(id);
		return "redirect:doorList";//先删除门店重定向到doorList方法中然后又跳转到查询页面
	}

}
