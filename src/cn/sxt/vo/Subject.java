package cn.sxt.vo;

import java.util.Date;

/**
 * 
 * �½�һ��student �� �����������Ժ�ʹ��ʱ,ֱ�Ӱ�student��װ��һ��student������
 * �ڽ�������ʱ,�Ϳ��԰�student��������list������,����student �Ĵ�ȡ
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
