package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Classs;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;
/*
 * 
 * дһ�� ��ɾ�ò�Ľӿ� 
 * 
 * */
public interface ClasssDao {
	//����
	public int update(String  sql);
	//��ѯ
	public List<Classs> list(String sql);
	public Classs getById(String sql);
	public int totalCount(String sql);


}
