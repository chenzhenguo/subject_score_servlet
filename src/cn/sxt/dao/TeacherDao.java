package cn.sxt.dao;

import java.util.List;

import cn.sxt.bean.TeacherBean;
import cn.sxt.vo.Teacher;
/*
 * 
 * дһ�� ��ɾ�ò�Ľӿ� 
 * 
 * */
public interface TeacherDao {
	//����
	public int update(String  sql);
	//��ѯ
	public List<TeacherBean> list(String sql);
	public Teacher getById(String sql);
	public int totalCount(String sql);


}
