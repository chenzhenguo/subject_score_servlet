package cn.sxt.service;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Reason;
import cn.sxt.vo.Status;

public interface StatusService {
	//���
	public int add(Status status);
	//�޸�
	public int update(Status status);
	//ɾ��
	public int delete(int id);
	//��ѯ
	public List<Status> list(PageUtil pu ,Status status);
	//��ȡ��ҳ��
	public int totalCount(Status status);

}
