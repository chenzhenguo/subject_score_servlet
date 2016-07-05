package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.StatusDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Status;

public class StatusDaoImpl  extends BaseDao implements StatusDao {

	@Override
	public List<Status> list(String sql) {
		List<Status> list =new ArrayList<Status>();
		ResultSet rs= this.executeQuery(sql);
		try {
			while(rs.next()){
				Status r = new Status();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
		
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list.size()>0?list:null;
	}

	@Override
	public Status getById(String sql) {
		ResultSet rs= this.executeQuery(sql);
		try {
			if(rs.next()){
				Status r = new Status();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
			
				return r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}
	
	
	

}
