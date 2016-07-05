package cn.sxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 新建一个JDBC的基础类
 * 用来封装 连接数据库的方法
 * 在通过继承调用其  exeUpdate 实现增删改的功能,
 * 调用exequery实现数据的查询
 * 
 * 
 * */

public class BaseDao {
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	public void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/score";
			conn = DriverManager.getConnection(url, "root", "123456");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}

	}
//关闭
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	//增删改
	public int executeUpdate(String sql) {
		try {
			getConnection();
			st = conn.createStatement();
			System.out.println(sql);
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return -1;

	}
//查询
	public ResultSet exeQuery(String sql) {
		try {
			getConnection();
			st = conn.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ResultSet executeQuery(String sql){
		try {
			getConnection();
			st = conn.createStatement();
			return rs=st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int totalCount(String sql) {
		ResultSet rs = this.executeQuery(sql);
		try {
			if(rs.next()){
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}
	public int update(String sql) {
		return this.executeUpdate(sql);
	}
	public int getMaxId(String sql){
		ResultSet rs = this.executeQuery(sql);
		try {
			if(rs.next()){
				return rs.getInt("mid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return -1;
	}
	
	
	

}
