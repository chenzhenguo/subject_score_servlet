package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.UserDao;
import cn.sxt.dao.impl.UserDaoImpl;
import cn.sxt.service.UserService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User login(User user) {
		StringBuffer sql = new StringBuffer("select * from t_user where 1=1 ");
		if(user.getName()!= null);
		sql.append("and name = '").append(user.getName()).append("'");
		sql.append("and pwd ='").append(user.getPwd()).append("'");
		return userDao.getById(sql.toString());
			
		
	}

	@Override
	public List<User> list(PageUtil pu, User user) {
		StringBuffer sql = new StringBuffer("select * from  t_user where 	1=1");
		if (user.getName() != null)
			sql.append("and name like '").append(user.getName()).append("%'");
		sql.append(",").append(pu.getPageSize());
		return userDao.list(sql.toString());

	}

	@Override
	public int totalCount(User user) {
		StringBuffer sql = new StringBuffer(
				"select count(id) cnt from t_user where 1=1 ");
		if (user.getName() != null)
			sql.append("and name like '").append(user.getName()).append("%'");
		return this.totalCount(user);

	}
}
