package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.dao.RecordDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Reason;
import cn.sxt.vo.Record;

public class RecordDaoImpl extends BaseDao implements RecordDao {

	@Override
	public List<Record> list(String sql) {
		List<Record> list= new ArrayList<Record>();
			ResultSet rs =	this.exeQuery(sql);
			try {
				while(rs.next()){
					Record r = new Record();
					Reason reason = new Reason();
					reason.setName(rs.getString("reasonName"));
					reason.setNum(rs.getInt("num"));
					r.setTeacherName(rs.getString("teacherName"));
					r.setOperateTime(rs.getDate("operateTime"));
					r.setReason(reason);
					list.add(r);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
		
		return list.size()>0?list:null;
	}



}
