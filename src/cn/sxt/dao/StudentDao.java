package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Student;
/*
 * 
 * 写一个 增删该查的接口 
 * 
 * */
public interface StudentDao {
	//更新
	public int update(String  sql);
	
	//查询
	public List<Student> list(String sql);
	public Student getById(String sql);
	public int totalCount(String sql);
	
	public int getMaxId(String sql);


}
