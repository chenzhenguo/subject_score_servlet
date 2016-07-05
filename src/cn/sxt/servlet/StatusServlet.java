package cn.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.service.StatusService;
import cn.sxt.service.impl.StatusServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Status;
@WebServlet("/status")
public class StatusServlet extends HttpServlet{
	
	private StatusService ssService = new StatusServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action==null||"list".equals(action)){
			list(req,resp);
		}
		
		

		
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PageUtil pu = new PageUtil();
		Status status = new Status();
		

		if(req.getParameter("name")!= null &&req.getParameter("name").trim().length()>0){
			status.setName(req.getParameter("name"));
		}
		String currPage = req.getParameter("currentPage");
		int currentPage=1;
		if(currPage!= null){
			currentPage = Integer.parseInt(currPage);
			if(currentPage<=1){
				currentPage=1;
			}
			if(currentPage>=pu.getTotalPage()){
				currentPage=pu.getTotalPage();
			}
		}
		pu.setCurrentPage(currentPage);
		req.setAttribute("list", ssService.list(pu, status));
		req.setAttribute("status", status);	
		req.setAttribute("page", pu);
		req.getRequestDispatcher("jsp/status/status.jsp").forward(req, resp);
	}

}
