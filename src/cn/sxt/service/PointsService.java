package cn.sxt.service;

import java.util.List;

import cn.sxt.bean.PointBean;
import cn.sxt.bean.StudentBean;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Points;
import cn.sxt.vo.Student;

/*
 * dao �� �� ��ֱ�Ӻ����ݿ� ����  ʵ�ֺ����ݿ����ɾ�ò�
 * servlet �������͵��� ���ַ����ķ���
 * service ʵ�ָ��ַ���,servlet �ڵ��÷���ʱ,ֱ�ӵ��øİ��е����ݼ���
 * vo�� д������������͵�set��get����
 * util  ���߰�
 * 
 * 
 * */

public interface PointsService {


	public int update(Points point);
	
	public List<Points> list(PageUtil pu,PointBean pb );
	

	public int totalCount (PointBean pb);

	
	

}
