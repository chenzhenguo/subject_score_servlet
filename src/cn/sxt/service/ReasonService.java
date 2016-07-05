package cn.sxt.service;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Reason;

public interface ReasonService {
	//添加
	public int add(Reason reason);
	//修改
	public int update(Reason reason);
	//删除
	public int delete(int id);
	//查询
	public List<Reason> list(PageUtil pu ,Reason reason);
	//获取总页数
	public int totalCount(Reason reason);

}
