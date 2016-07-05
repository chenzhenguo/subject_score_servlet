package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.DeptDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Dept;
import cn.sxt.vo.Reason;

public class DeptDaoImpl  extends BaseDao implements DeptDao {

	@Override
	public List<Dept> list(String sql) {
		List<Dept> list =new ArrayList<Dept>();
		ResultSet rs= this.executeQuery(sql);
		try {
			while(rs.next()){
				Dept dept = new Dept();
				dept.setId(rs.getInt("id"));
				dept.setName(rs.getString("name"));
				dept.setManager(rs.getString("manager"));
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list.size()>0?list:null;
	}

	@Override
	public Dept getById(String sql) {
		ResultSet rs= this.executeQuery(sql);
		try {
			if(rs.next()){
				Dept dept = new Dept();
				dept.setId(rs.getInt("id"));
				dept.setName(rs.getString("name"));
				dept.setManager(rs.getString("manager"));
				return dept;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}
	
	
	

}
