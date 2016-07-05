package cn.sxt.service;

import java.util.List;

import cn.sxt.bean.PointBean;
import cn.sxt.bean.StudentBean;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Points;
import cn.sxt.vo.Student;

/*
 * dao 包 中 的直接和数据库 交互  实现和数据库的增删该查
 * servlet 是用来和调用 各种方法的分配
 * service 实现各种方法,servlet 在调用方法时,直接调用改包中的数据即可
 * vo包 写入各种数据类型的set和get方法
 * util  工具包
 * 
 * 
 * */

public interface PointsService {


	public int update(Points point);
	
	public List<Points> list(PageUtil pu,PointBean pb );
	

	public int totalCount (PointBean pb);

	
	

}
