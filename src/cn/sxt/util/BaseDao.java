package cn.sxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * �½�һ��JDBC�Ļ�����
 * ������װ �������ݿ�ķ���
 * ��ͨ���̳е�����  exeUpdate ʵ����ɾ�ĵĹ���,
 * ����exequeryʵ�����ݵĲ�ѯ
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
			System.out.println("��������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}

	}
//�ر�
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

	//��ɾ��
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
//��ѯ
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
