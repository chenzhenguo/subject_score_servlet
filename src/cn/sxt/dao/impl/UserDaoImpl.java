package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.UserDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int update(String sql) {
	return 	this.executeUpdate(sql);
		
	}

	@Override
	public List<User> list(String sql) {
		List<User> list = new ArrayList<User>();
		ResultSet rs = this.exeQuery(sql);
		try {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return list.size() > 0 ? list : null;

	}

	public User getById(String sql) {
		ResultSet rs = this.exeQuery(sql);
		try {
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;

	}

	@Override
	public int totalCount(String sql) {

		ResultSet rs = this.exeQuery(sql);
		try {
			if (rs.next()) {
			return	rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return -1;

	}

}
