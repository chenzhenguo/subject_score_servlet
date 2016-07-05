package cn.sxt.service;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Reason;

public interface ReasonService {
	//���
	public int add(Reason reason);
	//�޸�
	public int update(Reason reason);
	//ɾ��
	public int delete(int id);
	//��ѯ
	public List<Reason> list(PageUtil pu ,Reason reason);
	//��ȡ��ҳ��
	public int totalCount(Reason reason);

}
