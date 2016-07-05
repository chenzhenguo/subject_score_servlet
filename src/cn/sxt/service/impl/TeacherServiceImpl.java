package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.bean.TeacherBean;
import cn.sxt.dao.TeacherDao;
import cn.sxt.dao.impl.TeacherDaoImpl;
import cn.sxt.service.TeacherService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Teacher;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao teacherDao = new TeacherDaoImpl();
	private TeacherBean tb =  new TeacherBean();

	public List<TeacherBean> list(PageUtil pu, TeacherBean tb) {

		StringBuffer sql = new StringBuffer(
				"select   t.id id, t.name   name ,  t.sex sex ,t.hireDate hireDate, t.workAge workAge , t.positionId positionId ,t.deptId deptId  ,  p.id  pId ,  p.name pName   , dept.id  deptId2 ,dept.name deptName   from t_teacher t ,t_position p ,t_dept dept  where t.deptId=dept.id and t.positionId=p.id ");
		if(tb.getName()!=null){
			sql.append("and t.name like '").append(tb.getName()).append("%'");
		}
		if(tb.getWorkAge()!=0){
			sql.append("and t.workAge =").append(tb.getWorkAge());
		}
		if(tb.getPositionId()!=0){
			 sql.append("and t.positionId =").append(tb.getPositionId());
			 
		}
		if(tb.getDeptId()!=0){
			 sql.append(",and t.deptId =").append(tb.getDeptId());
		}
		if(tb.getpId()!=0)
			 sql.append("and t.pId =").append(tb.getpId()!=0);
		if(tb.getpName()!=null){
			sql.append("and p.pName like '").append(tb.getpName()).append("%'");
		}if(tb.getDeptName()!=null){
			sql.append("and  dept.deptname like '").append(tb.getDeptName()).append("%'");
		}if(tb.getHireDate()!=null){
			sql.append("and t.hireDate  like '").append(tb.getDeptName()).append("%'");
		}
		
		sql.append(" limit  ")
		.append((pu.getCurrentPage() - 1) * pu.getPageSize())
		.append(",").append(pu.getPageSize());
		System.out.println(sql.toString());
		return teacherDao.list(sql.toString());
		
		
	}
	@Override
	public TeacherBean getById(int id) {
	return null;
		
	}
	@Override
	public int totalCount(TeacherBean tb) {

		StringBuffer sql = new StringBuffer(
				"select count(id) cnt from t_teacher where 1=1  ");
					
		if(tb.getName()!=null){
			sql.append("and name like '").append(tb.getName()).append("%'");
		}
		if(tb.getWorkAge()!=0){
			sql.append("and workAge =").append(tb.getWorkAge());
		}
		if(tb.getPositionId()!=0){
			 sql.append("and positionId =").append(tb.getPositionId());
			 
		}
		if(tb.getDeptId()!=0){
			 sql.append("and deptId =").append(tb.getDeptId());
		}if(tb.getHireDate()!=null){
			sql.append("and hireDate  like '").append(tb.getDeptName()).append("%'");
		}
		if(tb.getpId()!=0)
			 sql.append("and pId =").append(tb.getpId()!=0);
		if(tb.getpName()!=null){
			sql.append("and pName like '").append(tb.getpName()).append("%'");
		}if(tb.getDeptName()!=null){
			sql.append("and deptname like '").append(tb.getDeptName()).append("%'");
		}
		System.out.println("totalCount"+sql.toString());
		return teacherDao.totalCount(sql.toString());
	}
	
	

}
