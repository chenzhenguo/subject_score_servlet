package cn.sxt.service;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Record;

public interface RecordService {
	public int add(Record record);
	public int update(Record record);
	public int delete(int id);
	public List<Record> list(PageUtil pu,int sid);
	public int totalCout (int sid);

}
