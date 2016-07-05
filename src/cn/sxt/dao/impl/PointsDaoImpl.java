package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.PointsDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Points;
import cn.sxt.vo.Status;
import cn.sxt.vo.Student;

public class PointsDaoImpl extends BaseDao implements PointsDao {

	@Override
	public int update(String sql) {
		return this.executeUpdate(sql);

	}
	
	@Override
	public List<Points> list(String sql) {
		List<Points> list = new ArrayList<Points>();
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

				Status status = new Status(rs.getInt("tid"),
						rs.getString("tname"));
				stu.setStatus(status);
				Points p = new Points();
				p.setScore(rs.getInt("score"));
				p.setStudent(stu);
				list.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}

		return list.size() > 0 ? list : null;

	}

	public Points getById(String sql) {
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
				Status status = new Status(rs.getInt("tid"),
						rs.getString("tname"));
				stu.setStatus(status);
				Points p = new Points();
				p.setStudent(stu);
				p.setScore(rs.getInt("score"));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;
	}

	

}
