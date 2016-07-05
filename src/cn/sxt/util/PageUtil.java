package cn.sxt.util;
/**
 * 
 * �����б��ÿҳ����ʾ
 * ��Ҫ�½�һ��PageUtil�ķ�����
 * �趨�趨����ȡҳ��ĵ�ǰҳ����ҳ��
 *  
 * 
 *
 */

public class PageUtil {
	//ÿҳ��ʾ��¼��
	private int pageSize =Constants.PAGE_SIZE;
	//�ܼ�¼��
	private int totalCount;
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//��ҳ��
	private int totalPage;
	//��ǰҳ--Ϊ�˻�ȡ����
	private int currentPage;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}

	//������ҳ��
	//��ҳ������ �ܼ�¼�� ���� ÿҳ�� ,�������� ��ҳ�� +1
	public int getTotalPage() {
		totalPage =   totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
		return totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	

}
