package cn.sxt.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.bean.TeacherBean;
import cn.sxt.service.TeacherService;
import cn.sxt.service.impl.TeacherServiceImpl;
import cn.sxt.util.PageUtil;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	TeacherService ts = new TeacherServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		if (action == null || "list".equals(action)) {
			list(req, resp);
		}

	}

	private void list(HttpServletRequest req, HttpServletResponse resp) {
		TeacherBean tb =  condition(req);
		PageUtil pu = new PageUtil();
		pu.setTotalCount(ts.totalCount(tb));
		String currPage = req.getParameter("currentPage");
		int currentPage = 1;
		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
			if (currentPage < 1) {
				currentPage = 1;
			}
			if(currentPage>ts.totalCount(tb)){
				currentPage=ts.totalCount(tb);
			}
		}
		pu.setCurrentPage(currentPage);
		req.setAttribute("list", ts.list(pu, tb));
		req.setAttribute("page", pu);
		req.setAttribute("tb", tb);

		try {
			req.getRequestDispatcher("jsp/teacher/teacher.jsp").forward(req,resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private  TeacherBean condition(HttpServletRequest req){
		TeacherBean tb = new TeacherBean();
		if(req.getParameter("name")!=null&&req.getParameter("name").trim().length()>0){
			tb.setName(req.getParameter("name"));
		}
		if(req.getParameter("workAge")!=null&&req.getParameter("workAge").trim().length()>0){
			tb.setWorkAge(Integer.parseInt(  req.getParameter("workAge")) );
		}
		if(req.getParameter("deptName")!=null&&req.getParameter("deptName").trim().length()>0){
			tb.setDeptName(req.getParameter("deptName"));
			
		}
		if(req.getParameter("pName")!=null&&req.getParameter("pName").trim().length()>0){
			tb.setpName(req.getParameter("pName"));
		}
		if(req.getParameter("hireDate")!=null&&req.getParameter("hireDate").trim().length()>0){
			try {
				tb.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("hireDate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tb;
		
	}
	
	
	
}
