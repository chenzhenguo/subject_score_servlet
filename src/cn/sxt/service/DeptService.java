package cn.sxt.service;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Dept;

public interface DeptService {
	//���
	public int add(Dept dept);
	//�޸�
	public int update(Dept dept);
	//ɾ��
	public int delete(int id);
	//��ѯ
	public List<Dept> list(PageUtil pu ,Dept dept);
	//��ȡ��ҳ��
	public int totalCount(Dept dept);

}
