package cn.sxt.service;

import java.util.List;

import cn.sxt.bean.PointBean;
import cn.sxt.bean.StudentBean;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

/*
 * dao �� �� ��ֱ�Ӻ����ݿ� ����  ʵ�ֺ����ݿ����ɾ�ò�
 * servlet �������͵��� ���ַ����ķ���
 * service ʵ�ָ��ַ���,servlet �ڵ��÷���ʱ,ֱ�ӵ��øİ��е����ݼ���
 * vo�� д������������͵�set��get����
 * util  ���߰�
 * 
 * 
 * */

public interface ClasssService {



	//��ѯ  �ڵ��ò�ѯ����ʱ,���ڲ�ѯ��������ͬ,ͬʱΪ�˷�ҳ��Ч��,��Ҫ����StudentBean ����
	//�� PageUtil ����,  ��ʱֱ����sql�����ȡ�� ��Щ�����е����ݼ���
	public List<Classs > list(PageUtil pu,Classs cs);
	public  Classs getById(int id);
	public int totalCount (Classs cs);

	

}
