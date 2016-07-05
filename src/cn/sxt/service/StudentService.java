package cn.sxt.service;

import java.util.List;

import cn.sxt.bean.StudentBean;
import cn.sxt.util.PageUtil;
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

public interface StudentService {
	//���
	public int add(Student stu);
	public int add(List<Student> stus);
	//�޸�
	public int update(Student stu);
	//ɾ��
	public int delete(Student stu);
	//�޸�״̬
	public int updateStatus(Student stu);
	//��ѯ  �ڵ��ò�ѯ����ʱ,���ڲ�ѯ��������ͬ,ͬʱΪ�˷�ҳ��Ч��,��Ҫ����StudentBean ����
	//�� PageUtil ����,  ��ʱֱ����sql�����ȡ�� ��Щ�����е����ݼ���
	public List<Student> list(PageUtil pu,StudentBean sb );
	//��ȡ �б������, ��ʹ�÷�ҳЧ��ʹ�ø÷���
	//Ϊ���ڲ�ѯʱ Ҳͬ���з�ҳЧ����ʵ��,�ͱ������StudentBean �Ķ���,
	//���Ѳ�ѯ����������StudentBean��,����Ի�ȡStudnetBean�е���Ϣ,��ѯ�����������Ƶ� �б�����

	public int totalCount (StudentBean sb);
	public  Student getById(int id);
	
	

}
