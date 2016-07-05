package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.bean.TeacherBean;
import cn.sxt.dao.TeacherDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Teacher;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	public int update(String sql) {
		return this.executeUpdate(sql);
	}

	// 查询 方法,通过调用list方法,返回一个 List的集合
	public List<TeacherBean> list(String sql) {
		List<TeacherBean> list = new ArrayList<TeacherBean>();

		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {

				TeacherBean tb = new TeacherBean();
				tb.setId(rs.getInt("id"));
				tb.setName(rs.getString("name"));
		
				tb.setSex(rs.getInt("sex"));
				tb.setWorkAge(rs.getInt("workAge"));
				tb.setPositionId(rs.getInt("positionId"));
				tb.setDeptId(rs.getInt("deptId"));
				tb.setDeptName(rs.getString("deptName"));
				tb.setpId(rs.getInt("pId"));
				tb.setpName(rs.getString("pName"));
				tb.setHireDate(rs.getDate("hireDate"));
				list.add(tb);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			this.close();
		}
		return list.size()>0?list:null;

	}

	public Teacher getById(String sql) {
		ResultSet rs = this.exeQuery(sql);

		try {
			if (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getInt("sex"));
				teacher.setWorkAge(rs.getInt("workAge"));
				teacher.setPositionId(rs.getInt("position"));
				teacher.setDepeId(rs.getInt("deptId"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setHireDate(rs.getDate("hireDate"));
				return teacher;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}

		return null;

	}

	public int totalCount(String sql) {
		ResultSet rs = this.executeQuery(sql);
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
