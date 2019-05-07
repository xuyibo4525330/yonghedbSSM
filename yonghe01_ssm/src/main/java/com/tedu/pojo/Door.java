package com.tedu.pojo;
/*
 * POJO(实体类)
 * 用于封装所有的门店信息
 */
public class Door {
	
	private Integer id;//门店ID
	private String name;//门店名称
	private String tel;//联系方式
	private String addr;//门店地址
	
	//声明getter和setter方法
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	//ToString方法
	@Override
	public String toString() {
		return "Door [id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
}
