package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.RecordDao;
import cn.sxt.dao.impl.RecordDaoImpl;
import cn.sxt.service.ReasonService;
import cn.sxt.service.RecordService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Reason;
import cn.sxt.vo.Record;

public class RecordServiceImpl implements RecordService{
	private RecordDao  recordDao = new RecordDaoImpl();

	@Override
	public int add(Record record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Record record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql="delete from t_reason where id="+id;
		return recordDao.update(sql);
	}

	@Override
	public List<Record> list(PageUtil pu, int sid) {
		StringBuffer sql = new StringBuffer("select  s.name reasonName , s.num num , t.name  teacherName, operateTime from t_record r,t_teacher t, t_reason s where r.tid = t.id and r.reasonId = s.id and r.sid ="+sid);
		sql.append(",").append(pu.getPageSize());
		return recordDao.list(sql.toString());
	}

	@Override
	public int totalCout(int sid) {
		StringBuffer sql = new StringBuffer("select count(id) cnt from t_record where sid="+sid);
		return recordDao.totalCount(sql.toString());
	}
	
	
}