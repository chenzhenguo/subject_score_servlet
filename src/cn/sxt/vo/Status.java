package cn.sxt.vo;
/*
 * ����һ��ѧ��״̬��
 * 
 * */
public class Status {
 private 	int id;
private   String name;
public Status(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Status() {
	super();
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


}
