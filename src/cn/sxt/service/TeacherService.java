package cn.sxt.service;

import java.util.List;

import cn.sxt.bean.TeacherBean;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Teacher;

/*
 * dao �� �� ��ֱ�Ӻ����ݿ� ����  ʵ�ֺ����ݿ����ɾ�ò�
 * servlet �������͵��� ���ַ����ķ���
 * service ʵ�ָ��ַ���,servlet �ڵ��÷���ʱ,ֱ�ӵ��øİ��е����ݼ���
 * vo�� д������������͵�set��get����
 * util  ���߰�
 * 
 * 
 * */

public interface TeacherService {



	//��ѯ  �ڵ��ò�ѯ����ʱ,���ڲ�ѯ��������ͬ,ͬʱΪ�˷�ҳ��Ч��,��Ҫ����StudentBean ����
	//�� PageUtil ����,  ��ʱֱ����sql�����ȡ�� ��Щ�����е����ݼ���
	public List<TeacherBean > list(PageUtil pu,TeacherBean tb);
	public  TeacherBean getById(int id);
	public int totalCount (TeacherBean teacher);
	

}
