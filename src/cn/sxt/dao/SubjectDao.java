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
public interface SubjectDao {
	//����
	public int update(String  sql);
	//��ѯ
	public List<Subject> list(String sql);
	public Subject getById(String sql);
	public int totalCount(String sql);


}
