package cn.sxt.servlet;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.service.PointsService;
import cn.sxt.service.ReasonService;
import cn.sxt.service.impl.PointsServiceImpl;
import cn.sxt.service.impl.ReasonServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Reason;
@WebServlet("/reason")
public class ReasonServlet extends HttpServlet{
	
	private ReasonService rsService = new ReasonServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action==null||"list".equals(action)){
			list(req,resp);
		}
		
		

		
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PageUtil pu = new PageUtil();
		Reason reason = new Reason();
		

		if(req.getParameter("name")!= null &&req.getParameter("name").trim().length()>0){
			reason.setName(req.getParameter("name"));
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
		req.setAttribute("list", rsService.list(pu, reason));
		req.setAttribute("reason", reason);	
		req.setAttribute("page", pu);
		req.getRequestDispatcher("jsp/reason/reason.jsp").forward(req, resp);
	}

}
