package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Record;

public interface RecordDao {
	public int update(String sql);
	public List<Record> list(String sql);
	public int totalCount(String sql); 

}
