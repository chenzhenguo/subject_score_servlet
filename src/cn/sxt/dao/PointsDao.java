package cn.sxt.dao;


import java.util.List;

import cn.sxt.vo.Points;
import cn.sxt.vo.Student;
/*
 * 
 * дһ�� ��ɾ�ò�Ľӿ� 
 * 
 * */
public interface PointsDao {
	//����
	public int update(String  sql);
	//��ѯ
	public List<Points> list(String sql);
	public Points getById(String sql);

	public int totalCount(String sql);

}
