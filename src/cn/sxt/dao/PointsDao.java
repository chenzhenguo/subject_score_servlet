package cn.sxt.dao;


import java.util.List;

import cn.sxt.vo.Points;
import cn.sxt.vo.Student;
/*
 * 
 * 写一个 增删该查的接口 
 * 
 * */
public interface PointsDao {
	//更新
	public int update(String  sql);
	//查询
	public List<Points> list(String sql);
	public Points getById(String sql);

	public int totalCount(String sql);

}
