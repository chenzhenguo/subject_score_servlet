package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.User;

public interface UserDao {
	//����
	public int update(String sql);
		//��ѯ
	public List<User> list(String sql);
	public User getById(String sql);
	
	

}
