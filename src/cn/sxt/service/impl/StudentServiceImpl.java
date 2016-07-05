package cn.sxt.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.bean.StudentBean;
import cn.sxt.dao.PointsDao;
import cn.sxt.dao.StudentDao;
import cn.sxt.dao.UserDao;
import cn.sxt.dao.impl.PointsDaoImpl;
import cn.sxt.dao.impl.StudentDaoImpl;
import cn.sxt.dao.impl.UserDaoImpl;
import cn.sxt.service.StudentService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao stuDao = new StudentDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private PointsDao pntDao = new PointsDaoImpl();

	public int add(Student stu) {
		StringBuffer sql = new StringBuffer(
				"insert into t_student  (name,age,sex,idCard,phone,mayor,statusId,education,school,address,hireDate)");
		sql.append("values(");
		sql.append("'" + stu.getName() + "',");
		sql.append("'" + stu.getAge() + "',");
		sql.append("'" + stu.getSex() + "',");
		sql.append("'" + stu.getIdCard() + "',");
		sql.append("'" + stu.getPhone() + "',");
		sql.append("'" + stu.getMayor() + "',");
		sql.append("'" + stu.getStatusId() + "',");
		sql.append("'" + stu.getEducation() + "',");
		sql.append("'" + stu.getSchool() + "',");
		sql.append("'" + stu.getAddress() + "',");
	
			sql.append("'"
					+ new SimpleDateFormat("yyyy-MM-dd").format(stu
							.getHireDate()) + "'");
		
		sql.append(")");
		System.out.println("add>>>" + sql.toString());
		stuDao.update(sql.toString());
		//在添加用户的同时添加积分表和 用户账户表
		String sql1 ="insert into t_user (name,pwd,roleId)values('"+stu.getName()+"',1111,2);";
		userDao.update(sql1);
		//添加积分表时,要获取,刚添加的用户的id,
		String sql2 ="select max(id) mid from t_student;"; 
		int sid = stuDao.getMaxId(sql2);
		
		
		userDao.update(sql2.toString());
		String sql3 = "insert into  t_points(sid ,score) values("+sid+",100);";
		System.out.println("向用户id 添加分数"+sql3);
		return pntDao.update(sql3);

	}

	public int update(Student stu) {

		StringBuffer sql = new StringBuffer("update t_student set  ");
		sql.append("name='").append(stu.getName()).append("',");
		sql.append("age='").append(stu.getAge()).append("',");
		sql.append("sex='").append(stu.getSex()).append("',");
		sql.append("idCard='").append(stu.getIdCard()).append("',");
		sql.append("phone='").append(stu.getPhone()).append("',");
		sql.append("mayor='").append(stu.getMayor()).append("',");
		sql.append("statusId='").append(stu.getStatusId()).append("',");
		sql.append("education='").append(stu.getEducation()).append("',");
		sql.append("school='").append(stu.getSchool()).append("',");
		sql.append("address='").append(stu.getAddress()).append("',");
		sql.append("hireDate='")
				.append(new SimpleDateFormat("yyyy-MM-dd").format(stu
						.getHireDate())).append("' ");
		sql.append("where id =").append(stu.getId());
		return stuDao.update(sql.toString());

	}

	public int delete(Student stu) {
		int id=	stu.getId();
		String sql ="delete from   t_student where id="+id;
		System.out.println("删除数据"+sql);
	return 	stuDao.update(sql);
		
	}

	public int updateStatus(Student stu) {
		return 0;
	}

	public List<Student> list(PageUtil pu, StudentBean sb) {

		StringBuffer sql = new StringBuffer(
				"select   s.id  id, s.name  name,s.age age,s.sex sex,  s.statusId statusId,s.idCard idCard ,s.phone phone ,s.mayor mayor ,s.education education , s.school school , s.address address ,s.hireDate , t.id tid ,t.name tname     from t_student  s  ,t_status t where  s.statusId=t.id  ");
		if (sb.getAge() != null)
			sql.append("and age=").append(sb.getAge());
		if (sb.getEducation() != null)
			sql.append("and education  ='").append(sb.getEducation())
					.append("',");
		if (sb.getHireDate() != null)
			sql.append("and hiredate ='").append(sb.getHireDate()).append("'");
		if (sb.getMayor() != null)
			sql.append("and mayor ='").append(sb.getMayor()).append("'");
		if (sb.getSchool() != null)
			sql.append("and school ='").append(sb.getSchool()).append("'");
		if (sb.getName() != null)
			sql.append("and s.name like '").append(sb.getName()).append("%' ");
		if (sb.getPhone() != null)
			sql.append("and s.phone like '").append(sb.getPhone()).append("%' ");
		if (sb.getClassName() != null){
			sql.append(
					"and id  in ( select sid from t_student_class where cid =(select id from  t_class where  s.name =' ")
					.append(sb.getName()).append("'))");}		
			sql.append(" limit  ")
					.append((pu.getCurrentPage() - 1) * pu.getPageSize())
					.append(",").append(pu.getPageSize());
		
		System.out.println(sql.toString());
		return stuDao.list(sql.toString());

	}

	public int totalCount(StudentBean sb) {
		StringBuffer sql = new StringBuffer(
				"select count(id) cnt from t_student where 1=1");
		if (sb.getAge() != null)
			sql.append(" and age=").append(sb.getAge());
		if (sb.getEducation() != null)
			sql.append(" and education='").append(sb.getEducation())
					.append("'");
		if (sb.getHireDate() != null)
			sql.append(" and hiredate='").append(sb.getHireDate()).append("'");
		if (sb.getMayor() != null)
			sql.append(" and mayor='").append(sb.getMayor()).append("'");
		if (sb.getSchool() != null)
			sql.append(" and school='").append(sb.getSchool()).append("'");
		if (sb.getName() != null)
			sql.append(" and name like '").append(sb.getName()).append("%'");
		if (sb.getPhone() != null)
			sql.append(" and phone like '").append(sb.getPhone()).append("%'");
		if (sb.getClassName() != null)
			sql.append(" and id in(")
					.append("select sid from t_student_class where cid =(select id from t_class where name='")
					.append(sb.getClassName()).append("')").append(")");
		
		System.out.println("total 总数>"+sql.toString());
		return stuDao.totalCount(sql.toString());

	}

	public int add(List<Student> stus) {
		for (int i = 0; i < stus.size(); i++) {
			Student stu = stus.get(i);
			this.add(stu);
		}
		return 1;

	}

	@Override
	public Student getById(int id) {
		String sql = "select * from t_student where id =" + id;
		return stuDao.getById(sql);

	}

}
