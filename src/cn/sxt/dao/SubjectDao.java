package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Classs;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;
/*
 * 
 * 写一个 增删该查的接口 
 * 
 * */
public interface SubjectDao {
	//更新
	public int update(String  sql);
	//查询
	public List<Subject> list(String sql);
	public Subject getById(String sql);
	public int totalCount(String sql);


}
