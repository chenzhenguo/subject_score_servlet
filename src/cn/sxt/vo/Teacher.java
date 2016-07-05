package cn.sxt.vo;

import java.util.Date;

public class Teacher {
	private int id;
	private String name;
	private int sex;
	private int workAge;
	private int positionId;
	private int depeId;
	private String phone;
	private Date hireDate;
	public Teacher(int id, String name, int sex, int workAge, int positionId,
			int depeId, String phone, Date hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.workAge = workAge;
		this.positionId = positionId;
		this.depeId = depeId;
		this.phone = phone;
		this.hireDate = hireDate;
	}
	public Teacher(String name, int sex, int workAge, int positionId,
			int depeId, String phone, Date hireDate) {
		super();
		this.name = name;
		this.sex = sex;
		this.workAge = workAge;
		this.positionId = positionId;
		this.depeId = depeId;
		this.phone = phone;
		this.hireDate = hireDate;
	}
	public Teacher() {
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getWorkAge() {
		return workAge;
	}
	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public int getDepeId() {
		return depeId;
	}
	public void setDepeId(int depeId) {
		this.depeId = depeId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	

}
