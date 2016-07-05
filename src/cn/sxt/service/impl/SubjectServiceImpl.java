package cn.sxt.service.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.bean.StudentBean;
import cn.sxt.dao.StudentDao;
import cn.sxt.dao.SubjectDao;
import cn.sxt.dao.impl.StudentDaoImpl;
import cn.sxt.dao.impl.SubjectDaoImpl;
import cn.sxt.service.StudentService;
import cn.sxt.service.SubjectService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class SubjectServiceImpl implements SubjectService {
	private SubjectDao subjectDao = new SubjectDaoImpl();

	public List<Subject> list(PageUtil pu, Subject subject) {

		StringBuffer sql = new StringBuffer(
				"select * from t_subject where 1=1  ");

		if (subject.getName() != null)
			sql.append("and name like'").append(subject.getName()).append("%'");

		if (pu.getCurrentPage() > 0) {
			sql.append(" limit  ")
					.append((pu.getCurrentPage() - 1) * pu.getPageSize())
					.append(",").append(pu.getPageSize());
		}
		System.out.println(sql.toString());
		return subjectDao.list(sql.toString());

	}

	@Override
	public Subject getById(int id) {
		Subject subject = new Subject();
		String sql = "select * from t_subject where 1=1 where id =" + id;
		return subjectDao.getById(sql);

	}
	
	public int totalCount(Subject subject) {
		StringBuffer sql=new StringBuffer("select count(id) cnt from t_subject where 1=1");
		if(subject.getName()!=null)
			sql.append(" and name like '").append(subject.getName()).append("%'");
		return subjectDao.totalCount(sql.toString());
	}

}
