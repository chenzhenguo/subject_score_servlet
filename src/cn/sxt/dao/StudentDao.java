package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Student;
/*
 * 
 * дһ�� ��ɾ�ò�Ľӿ� 
 * 
 * */
public interface StudentDao {
	//����
	public int update(String  sql);
	
	//��ѯ
	public List<Student> list(String sql);
	public Student getById(String sql);
	public int totalCount(String sql);
	
	public int getMaxId(String sql);


}
