package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.SubjectDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class SubjectDaoImpl extends BaseDao implements SubjectDao {

	public int update(String sql) {
		return this.executeUpdate(sql);
	}

	// 查询 方法,通过调用list方法,返回一个 List的集合
	public  List<Subject> list(String sql) {
		List<Subject>list= new ArrayList<Subject>();

		ResultSet rs=	this.exeQuery(sql);
			
			try {
				while(rs.next()){
					
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
					
				subject.setName(rs.getString("name"));
					list.add(subject);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.close();
			}
			return  list.size()>0 ?list:null;
			
		
	}

	public Subject getById(String sql) {
		ResultSet rs = this.exeQuery(sql);
		try {
			if (rs.next()) {
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				
				subject.setName(rs.getString("name"));
			
				return subject;

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
