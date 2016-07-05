package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Dept;

public interface DeptDao {

	public int update(String sql);
	public List<Dept> list(String sql);
	public Dept getById(String sql);
	public int totalCount (String sql);
}
