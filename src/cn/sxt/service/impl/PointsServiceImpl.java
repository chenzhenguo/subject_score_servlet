package cn.sxt.service.impl;

import java.awt.Point;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import cn.sxt.bean.PointBean;
import cn.sxt.dao.PointsDao;
import cn.sxt.dao.impl.PointsDaoImpl;
import cn.sxt.service.PointsService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Points;

public class PointsServiceImpl implements PointsService {
private PointsDao pd = new PointsDaoImpl();

	
	public int update(Points point) {
		return 0;
		
	}

	@Override
	public List<Points> list(PageUtil pu, PointBean pb) {
		StringBuffer sql = new StringBuffer(
				"select s.id id,s.name name , s.age age , s.sex sex , s.statusId statusId ,s.idCard idCard , s.phone phone ,s.mayor mayor , s.education education ,s.school school ,s.address address , s.hireDate hireDate , t.id tid , t.name  tname ,p.score score from t_student s , t_status t, t_points p where s.statusId = t.id  and p.sid=s.id");
		if(pb.getAge()!= null){
		sql.append("and  age =").append(pb.getAge());}
		if(pb.getScore()!= null){
		sql.append("and   score != null").append(pb.getScore());}
		
		if(pb.getEducation()!=null)
			sql.append(" and  s.education='").append(pb.getEducation()).append("'");
		if(pb.getHireDate()!=null)
			sql.append(" and  s.hiredate='").append(pb.getHireDate()).append("'");
		if(pb.getMayor()!=null)
			sql.append(" and s.mayor='").append(pb.getMayor()).append("'");
		if(pb.getSchool()!=null)
			sql.append(" and s.school='").append(pb.getSchool()).append("'");
		if(pb.getName()!=null)
			sql.append(" and s.name like '").append(pb.getName()).append("%'");
		if(pb.getPhone()!=null)
			sql.append(" and s.phone like '").append(pb.getPhone()).append("%'");
		if(pb.getClassName()!=null)
			sql.append(" and s.id  in(")
			.append("select sid from t_student_class where cid =(select id from t_class where name= ' ")
			.append(pb.getClassName())
			.append("')")
			.append(")");
		sql.append(" limit ").append((pu.getCurrentPage()-1)*pu.getPageSize())
		.append(",").append(pu.getPageSize());
		System.out.println("sql===="+sql.toString());
		return pd.list(sql.toString());
	}

	@Override
	public int totalCount(PointBean pb) {
		StringBuffer sql = new StringBuffer("select count(*) cnt from t_student s , t_status t where  s.statusId =t.id"); 
		if(pb.getAge()!=null)
			sql.append(" and s.age=").append(pb.getAge());
		if(pb.getScore()!=null)
			sql.append(" and p.score=").append(pb.getScore());
		if(pb.getEducation()!=null)
			sql.append(" and s.education='").append(pb.getEducation()).append("'");
		if(pb.getHireDate()!=null)
			sql.append(" and s.hiredate='").append(pb.getHireDate()).append("'");
		if(pb.getMayor()!=null)
			sql.append(" and s.mayor='").append(pb.getMayor()).append("'");
		if(pb.getSchool()!=null)
			sql.append(" and s.school='").append(pb.getSchool()).append("'");
		if(pb.getName()!=null)
			sql.append(" and s.name like '").append(pb.getName()).append("%'");
		if(pb.getPhone()!=null)
			sql.append(" and s.phone like '").append(pb.getPhone()).append("%'");
		if(pb.getClassName()!=null)
			sql.append(" and s.id in(")
			.append("select sid from t_student_class where cid =(select id from t_class where name='")
			.append(pb.getClassName())
			.append("')")
			.append(")");
		System.out.println("sql======="+sql.toString());
		return  pd.totalCount(sql.toString());
	}

}
