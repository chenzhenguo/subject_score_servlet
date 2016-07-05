package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.DeptDao;
import cn.sxt.dao.impl.DeptDaoImpl;
import cn.sxt.service.DeptService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Dept;
import cn.sxt.vo.Reason;

public class DeptServiceImpl  implements DeptService{
	private DeptDao deptDao = new DeptDaoImpl();

	@Override
	public int add(Dept dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Dept dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql ="delete from t_dept where id ="+id;
		return deptDao.update(sql);
	
	
	}

	@Override
	public List<Dept> list(PageUtil pu, Dept dept) {
 		StringBuffer sql = new StringBuffer("select * from t_dept where 1=1  ");
 		if(dept.getName()!=null)
 			sql.append("and name like '").append(dept.getName()).append("%'");
 		if(dept.getManager()!=null){
 			 sql.append("and manager like '").append(dept.getManager()).append("%'");
 		}
 		
 		
 			sql.append("   limit  ").append((pu.getCurrentPage()-1)*pu.getPageSize()).append(",").append(pu.getPageSize());
 			System.out.println(sql.toString());
 			return deptDao.list(sql.toString());
 		

	}

	@Override
	public int totalCount( Dept dept) {
		StringBuffer sql = new StringBuffer("select count (id)  cnt from t_dept where 1=1  ");
		if(dept.getName()!=null){
			sql.append("and name like '").append(dept.getName()).append("'%");
		}
		if(dept.getManager()!=null){
			 sql.append("and manager like '").append(dept.getManager()).append("%'");
		}
		
		return deptDao.totalCount(sql.toString());

	}

}
