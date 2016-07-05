package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.ReasonDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Reason;

public class ReasonDaoImpl  extends BaseDao implements ReasonDao {

	@Override
	public List<Reason> list(String sql) {
		List<Reason> list =new ArrayList<Reason>();
		ResultSet rs= this.executeQuery(sql);
		try {
			while(rs.next()){
				Reason r = new Reason();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setNum( rs.getInt("num"));
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
	public Reason getById(String sql) {
		ResultSet rs= this.executeQuery(sql);
		try {
			if(rs.next()){
				Reason r = new Reason();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setNum( rs.getInt("num"));
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
