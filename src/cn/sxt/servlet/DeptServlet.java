package cn.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.service.DeptService;
import cn.sxt.service.impl.DeptServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Dept;
@WebServlet("/dept")
public class DeptServlet extends HttpServlet{
	
	private DeptService deptService = new DeptServiceImpl();
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action==null||"list".equals(action)){
			list(req,resp);
		}
		
		

		
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PageUtil pu = new PageUtil();
		Dept  dept= new Dept();
		

		if(req.getParameter("name")!= null &&req.getParameter("name").trim().length()>0){
			dept.setName(req.getParameter("name"));
		}

		if(req.getParameter("manager")!= null &&req.getParameter("manager").trim().length()>0){
			dept.setName(req.getParameter("manager"));
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
		System.out.println("dept>>"+deptService.list(pu, dept).size());
		req.setAttribute("list", deptService.list(pu, dept));
		req.setAttribute("dept", dept);	
		req.setAttribute("page", pu);
		req.getRequestDispatcher("jsp/dept/dept.jsp").forward(req, resp);
	}

}
