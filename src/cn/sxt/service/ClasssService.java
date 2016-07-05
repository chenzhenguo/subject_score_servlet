package cn.sxt.service;

import java.util.List;

import cn.sxt.bean.PointBean;
import cn.sxt.bean.StudentBean;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

/*
 * dao 包 中 的直接和数据库 交互  实现和数据库的增删该查
 * servlet 是用来和调用 各种方法的分配
 * service 实现各种方法,servlet 在调用方法时,直接调用改包中的数据即可
 * vo包 写入各种数据类型的set和get方法
 * util  工具包
 * 
 * 
 * */

public interface ClasssService {



	//查询  在调用查询方法时,由于查询的条件不同,同时为了分页的效果,需要加入StudentBean 对象
	//和 PageUtil 对象,  到时直接在sql语句中取出 这些对象中的数据即可
	public List<Classs > list(PageUtil pu,Classs cs);
	public  Classs getById(int id);
	public int totalCount (Classs cs);

	

}
