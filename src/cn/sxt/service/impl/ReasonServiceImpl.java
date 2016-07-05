package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.ReasonDao;
import cn.sxt.dao.impl.ReasonDaoImpl;
import cn.sxt.service.ReasonService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Reason;

public class ReasonServiceImpl  implements ReasonService{
	private ReasonDao rsDao = new ReasonDaoImpl();

	@Override
	public int add(Reason reason) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Reason reason) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql ="delete from t_reason where id ="+id;
		return rsDao.update(sql);
	
	
	}

	@Override
	public List<Reason> list(PageUtil pu, Reason reason) {
 		StringBuffer sql = new StringBuffer("select * from t_reason where 1=1");
 		if(reason.getName()!=null)
 			sql.append("and name like '").append(reason.getName()).append("%'");
 			sql.append("   limit  ").append((pu.getCurrentPage()-1)*pu.getPageSize()).append(",").append(pu.getPageSize());
 			System.out.println(sql.toString());
 			return rsDao.list(sql.toString());
 		

	}

	@Override
	public int totalCount(Reason reason) {
		StringBuffer sql = new StringBuffer("select count (id)  cnt from t_reason where 1=1");
		if(reason.getName()!=null){
			sql.append("and name like '").append(reason.getName()).append("'%");
		}
		
		return rsDao.totalCount(sql.toString());

	}

}
