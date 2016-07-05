package cn.sxt.vo;

import java.util.Date;

/**
 * 
 * 新建一个student 类 这样可以在以后使用时,直接把student封装成一个student公用类
 * 在建立数组时,就可以把student这个类放入list数组中,方便student 的存取
 * 
 * 
 * */
public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", statusId=" + statusId + ", status="
				+ status + ", idCard=" + idCard + ", phone=" + phone
				+ ", mayor=" + mayor + ", education=" + education + ", school="
				+ school + ", address=" + address + ", hireDate=" + hireDate
				+ "]";
	}

	private int id;
	private String name;
	private int age;
	private int sex;
	private int statusId;
	private Status status;
	private String idCard;
	private String phone;
	private String mayor;
	private String education;
	private String school;
	private String address;
	private Date hireDate;

	public Student() {

	};

	public Student(String name, int age, int sex, int statusId, String idCard,
			String phone, String mayor, String education, String school,
			String address, Date hireDate) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.statusId = statusId;
		this.idCard = idCard;
		this.phone = phone;
		this.mayor = mayor;
		this.education = education;
		this.school = school;
		this.address = address;
		this.hireDate = hireDate;
	}

	public Student(int id, String name, int age, int sex, int statusId,
			String idCard, String phone, String mayor, String education,
			String school, String address, Date hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.statusId = statusId;
		this.idCard = idCard;
		this.phone = phone;
		this.mayor = mayor;
		this.education = education;
		this.school = school;
		this.address = address;
		this.hireDate = hireDate;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMayor() {
		return mayor;
	}

	public void setMayor(String mayor) {
		this.mayor = mayor;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

}
