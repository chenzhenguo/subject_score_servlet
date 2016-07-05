package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.StudentDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Status;
import cn.sxt.vo.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao {

	public int update(String sql) {
		return this.executeUpdate(sql);
	}

	// 查询 方法,通过调用list方法,返回一个 List的集合
	public List<Student> list(String sql) {
		List<Student> list = new ArrayList<Student>();
		ResultSet rs = this.exeQuery(sql);
		try {
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setAddress(rs.getString("address"));
				stu.setAge(rs.getInt("age"));
				stu.setEducation(rs.getString("education"));
				stu.setHireDate(rs.getDate("hireDate"));
				stu.setIdCard(rs.getString("idCard"));
				stu.setMayor(rs.getString("mayor"));
				stu.setName(rs.getString("name"));
				stu.setPhone(rs.getString("phone"));
				stu.setSchool(rs.getString("school"));
				stu.setSex(rs.getInt("sex"));
				stu.setStatusId(rs.getInt("statusId"));
				stu.setStatus(new Status(rs.getInt("tid"), rs
						.getString("tname")));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return list.size() > 0 ? list : null;

	}

	public Student getById(String sql) {
		ResultSet rs = this.exeQuery(sql);
		try {
			if (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setAddress(rs.getString("address"));
				stu.setAge(rs.getInt("age"));
				stu.setEducation(rs.getString("education"));
				stu.setHireDate(rs.getDate("hireDate"));
				stu.setIdCard(rs.getString("idCard"));
				stu.setMayor(rs.getString("mayor"));
				stu.setName(rs.getString("name"));
				stu.setPhone(rs.getString("phone"));
				stu.setSchool(rs.getString("school"));
				stu.setSex(rs.getInt("sex"));
				stu.setStatusId(rs.getInt("statusId"));
				return stu;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;

	}

	public int totalCount(String sql) {
		ResultSet rs = this.exeQuery(sql);
		try {
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return -1;
	}

}
