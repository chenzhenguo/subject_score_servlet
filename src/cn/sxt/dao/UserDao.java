package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.User;

public interface UserDao {
	//¸üĞÂ
	public int update(String sql);
		//²éÑ¯
	public List<User> list(String sql);
	public User getById(String sql);
	
	

}
