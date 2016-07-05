package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;




import cn.sxt.dao.ClasssDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Student;


public class ClasssDaoImpl extends BaseDao implements ClasssDao {

	public int update(String sql) {
		return this.executeUpdate(sql);
	}

	// 查询 方法,通过调用list方法,返回一个 List的集合
	public  List<Classs> list(String sql) {
		List<Classs>list= new ArrayList<Classs>();

		ResultSet rs=	this.executeQuery(sql);
		
		try {
			while(rs.next()){
				Classs classs = new Classs();
					classs.setId(rs.getString("id"));	
					classs.setName(rs.getString("name"));	
					classs.setType(rs.getString("type"));	
					classs.setOpenTime(rs.getDate("openTime"));
				list.add(classs);
			}
		} catch (Exception e) {
			
		}finally{
			this.close();
		}
		
		return  list.size()>0 ?list:null;	
		
	
	
		
	}

	public Classs getById(String sql) {
		ResultSet rs = this.exeQuery(sql);
	
		try {
			if (rs.next()) {
				Classs classs = new Classs();
				classs.setId(rs.getString("id"));	
				classs.setName(rs.getString("name"));	
				classs.setType(rs.getString("type"));	
				classs.setOpenTime(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("openTime")));
				return classs;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
