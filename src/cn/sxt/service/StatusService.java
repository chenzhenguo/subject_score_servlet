package cn.sxt.service;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Reason;
import cn.sxt.vo.Status;

public interface StatusService {
	//添加
	public int add(Status status);
	//修改
	public int update(Status status);
	//删除
	public int delete(int id);
	//查询
	public List<Status> list(PageUtil pu ,Status status);
	//获取总页数
	public int totalCount(Status status);

}
