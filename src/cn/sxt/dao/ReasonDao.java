package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Reason;

public interface ReasonDao {

	public int update(String sql);
	public List<Reason> list(String sql);
	public Reason getById(String sql);
	public int totalCount (String sql);
}
