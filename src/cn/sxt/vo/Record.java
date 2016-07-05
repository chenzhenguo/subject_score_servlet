package cn.sxt.vo;

/*
 *显示的数据
 * select   r.operateTime    ,s.name , rs.name , t.name   ,p.score  ,rs.num   from t_record r ,t_student s ,t_points p,  t_teacher t , t_reason rs  where r.sid=s.id and r.reasonId=rs.id and r.tid=t.id and p.sid=s.id
 * 
 * 
 * */


import java.sql.Date;

public class Record {
private int id;
private int reasonId;
private Reason reason;
private int tid;
private String teacherName;
private Date operateTime;
public Record(int id, int reasonId, Reason reason, int tid, String teacherName,
		Date operateTime) {
	super();
	this.id = id;
	this.reasonId = reasonId;
	this.reason = reason;
	this.tid = tid;
	this.teacherName = teacherName;
	this.operateTime = operateTime;
}
public Record(int reasonId, Reason reason, int tid, String teacherName,
		Date operateTime) {
	super();
	this.reasonId = reasonId;
	this.reason = reason;
	this.tid = tid;
	this.teacherName = teacherName;
	this.operateTime = operateTime;
}
public Record() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getReasonId() {
	return reasonId;
}
public void setReasonId(int reasonId) {
	this.reasonId = reasonId;
}
public Reason getReason() {
	return reason;
}
public void setReason(Reason reason) {
	this.reason = reason;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public Date getOperateTime() {
	return operateTime;
}
public void setOperateTime(Date operateTime) {
	this.operateTime = operateTime;
}



	
	
}
