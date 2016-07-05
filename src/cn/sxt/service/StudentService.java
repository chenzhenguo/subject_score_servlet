package cn.sxt.service;

import java.util.List;

import cn.sxt.bean.StudentBean;
import cn.sxt.util.PageUtil;
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

public interface StudentService {
	//添加
	public int add(Student stu);
	public int add(List<Student> stus);
	//修改
	public int update(Student stu);
	//删除
	public int delete(Student stu);
	//修改状态
	public int updateStatus(Student stu);
	//查询  在调用查询方法时,由于查询的条件不同,同时为了分页的效果,需要加入StudentBean 对象
	//和 PageUtil 对象,  到时直接在sql语句中取出 这些对象中的数据即可
	public List<Student> list(PageUtil pu,StudentBean sb );
	//获取 列表的总数, 当使用分页效果使用该方法
	//为了在查询时 也同样有分页效果的实现,就必须加入StudentBean 的对象,
	//当把查询的条件放入StudentBean中,便可以获取StudnetBean中的信息,查询到有条件限制的 列表总数

	public int totalCount (StudentBean sb);
	public  Student getById(int id);
	
	

}
