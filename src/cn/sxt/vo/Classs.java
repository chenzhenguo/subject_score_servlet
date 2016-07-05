package cn.sxt.vo;

import java.util.Date;

public class Classs {
	private String id;
	private String name;
	private String type;
	private Date  openTime;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime= openTime;
	}
	public Classs(String id, String name, String type, Date openTime) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.openTime = openTime;
	}
	public Classs() {
		super();
	}
	public Classs(String name, String type, Date openTime) {
		super();
		this.name = name;
		this.type = type;
		this.openTime = openTime;
	}
	
	

}
