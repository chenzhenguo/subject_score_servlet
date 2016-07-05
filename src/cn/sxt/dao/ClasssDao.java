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
public interface ClasssDao {
	//更新
	public int update(String  sql);
	//查询
	public List<Classs> list(String sql);
	public Classs getById(String sql);
	public int totalCount(String sql);


}
