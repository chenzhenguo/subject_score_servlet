package cn.sxt.util;
/**
 * 
 * 设置列表的每页的显示
 * 需要新建一个PageUtil的方法类
 * 设定设定并获取页码的当前页和总页数
 *  
 * 
 *
 */

public class PageUtil {
	//每页显示记录数
	private int pageSize =Constants.PAGE_SIZE;
	//总记录数
	private int totalCount;
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//总页数
	private int totalPage;
	//当前页--为了获取数据
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

	//计算总页数
	//总页数等于 总记录数 除以 每页数 ,若有余数 总页数 +1
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
