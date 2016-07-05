package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.StatusDao;
import cn.sxt.dao.impl.StatusDaoImpl;
import cn.sxt.service.StatusService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Status;
import cn.sxt.vo.Status;

public class StatusServiceImpl  implements StatusService{
	private StatusDao rsDao = new StatusDaoImpl();

	@Override
	public int add(Status status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Status status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql ="delete from t_status where id ="+id;
		return rsDao.update(sql);
	
	
	}

	@Override
	public List<Status> list(PageUtil pu, Status status) {
 		StringBuffer sql = new StringBuffer("select * from t_status where 1=1");
 		if(status.getName()!=null)
 			sql.append("and name like '").append(status.getName()).append("%'");
 			sql.append("   limit  ").append((pu.getCurrentPage()-1)*pu.getPageSize()).append(",").append(pu.getPageSize());
 			System.out.println(sql.toString());
 			return rsDao.list(sql.toString());
 		

	}

	@Override
	public int totalCount(Status status) {
		StringBuffer sql = new StringBuffer("select count (id)  cnt from t_status where 1=1");
		if(status.getName()!=null){
			sql.append("and name like '").append(status.getName()).append("'%");
		}
		
		return rsDao.totalCount(sql.toString());

	}

}
