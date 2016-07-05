package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Status;

public interface StatusDao {

	public int update(String sql);
	public List<Status> list(String sql);
	public Status getById(String sql);
	public int totalCount (String sql);
}
