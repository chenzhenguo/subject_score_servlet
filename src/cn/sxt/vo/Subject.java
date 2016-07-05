package cn.sxt.vo;

import java.util.Date;

/**
 * 
 * 新建一个student 类 这样可以在以后使用时,直接把student封装成一个student公用类
 * 在建立数组时,就可以把student这个类放入list数组中,方便student 的存取
 * 
 * 
 * */
public class Subject {
	private int id;
	private String name;

	public Subject() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Subject(String name) {
		super();
		this.name = name;
	}


	



}
