package cn.sxt.service;

import java.util.List;

import cn.sxt.dao.UserDao;
import cn.sxt.dao.impl.UserDaoImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.User;

public interface UserService {
	//���
	public int add(User user);
	//�޸�
	public int update(User user);

	public User login(User user);
	public List<User> list(PageUtil pu ,User user);
	public int totalCount(User user);
	
}
