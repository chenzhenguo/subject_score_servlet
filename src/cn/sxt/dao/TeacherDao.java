package cn.sxt.dao;

import java.util.List;

import cn.sxt.bean.TeacherBean;
import cn.sxt.vo.Teacher;
/*
 * 
 * 写一个 增删该查的接口 
 * 
 * */
public interface TeacherDao {
	//更新
	public int update(String  sql);
	//查询
	public List<TeacherBean> list(String sql);
	public Teacher getById(String sql);
	public int totalCount(String sql);


}
