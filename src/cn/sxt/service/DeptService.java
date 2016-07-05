package cn.sxt.service;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Dept;

public interface DeptService {
	//添加
	public int add(Dept dept);
	//修改
	public int update(Dept dept);
	//删除
	public int delete(int id);
	//查询
	public List<Dept> list(PageUtil pu ,Dept dept);
	//获取总页数
	public int totalCount(Dept dept);

}
