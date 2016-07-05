package cn.sxt.service.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.bean.StudentBean;
import cn.sxt.dao.ClasssDao;
import cn.sxt.dao.StudentDao;
import cn.sxt.dao.SubjectDao;
import cn.sxt.dao.impl.ClasssDaoImpl;
import cn.sxt.dao.impl.StudentDaoImpl;
import cn.sxt.dao.impl.SubjectDaoImpl;
import cn.sxt.service.ClasssService;
import cn.sxt.service.StudentService;
import cn.sxt.service.SubjectService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class ClasssServiceImpl implements ClasssService {
	private ClasssDao classsDao = new ClasssDaoImpl();

	public List<Classs> list(PageUtil pu, Classs classs) {

		StringBuffer sql = new StringBuffer(
				"select * from t_class where 1=1  ");

		if (classs.getName() != null)
			sql.append("and name like'").append(classs.getName()).append("%'");
		if(classs.getType() != null)
			sql.append("and type like'").append(classs.getName()).append("%'");

		if (pu.getCurrentPage() > 0) {
			sql.append(" limit  ")
					.append((pu.getCurrentPage() - 1) * pu.getPageSize())
					.append(",").append(pu.getPageSize());
		}
		System.out.println(sql.toString());
		return classsDao.list(sql.toString());
	}
	@Override
	public Classs getById(int id) {
	
		String sql = "select * from t_class where 1=1 where id =" + id;
		
		return classsDao.getById(sql);
	}
	@Override
	public int totalCount(Classs cs) {
		String sql ="select count(*) cnt from t_class where 1==1 ";
		
		if(cs.getName()!= null){
			sql+="and name ="+cs.getName();
		}
		if(cs.getType()!= null){
				sql+= "and type ="+cs.getType();
		}
		return  classsDao.totalCount(sql);
	}
	
	

}
