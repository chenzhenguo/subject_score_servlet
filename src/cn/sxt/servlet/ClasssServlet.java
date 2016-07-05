package cn.sxt.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.bean.StudentBean;
import cn.sxt.service.ClasssService;
import cn.sxt.service.StudentService;
import cn.sxt.service.SubjectService;
import cn.sxt.service.impl.ClasssServiceImpl;
import cn.sxt.service.impl.StudentServiceImpl;
import cn.sxt.service.impl.SubjectServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

@WebServlet("/classs")
public class ClasssServlet extends HttpServlet {
	ClasssService	classsService = new ClasssServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		if (action == null || "list".equals(action)) {
			list(req, resp);
		} else if ("toUpdate".equals(action)) {
			toUpdate(req, resp);
		} else if ("add".equals(action)) {
			add(req, resp);
		}else if("delete".equals(action)){
			delete(req,resp);
		}else if("update".equals(action))
			update(req,resp);
		}
		

	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}


	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}


	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}


	private void update(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}


	

	





	private void list(HttpServletRequest req, HttpServletResponse resp)  {
		// 开始封装条件.当条件查询调用该方法时,会传一个studentBean的对象,通过调用对象中的数据,列出列表
			PageUtil pu = new PageUtil();
			Classs	 classs = condition(req);

		// 获取主页面的currentPage 当前页面的值,并判断是否为空,如果为空则默认为第一页,弱国不为空,主页面点击下一页时会在当前页加一
		String currPage = req.getParameter("currentPage");
		int currentPage = 1;

		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
			if (currentPage < 1) {
				currentPage = 1;
			}
			if (currentPage > pu.getTotalPage())
				currentPage = pu.getTotalPage();
		}
		pu.setCurrentPage(currentPage);
		// 把stuService 调用list的功能,列出当前页面
		
		req.setAttribute("list", classsService.list(pu, classs));
		req.setAttribute("page", pu);
		req.setAttribute("classs",  classs);

		try {
			req.getRequestDispatcher("/jsp/classs/classs.jsp").forward(req,
					resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Classs condition(HttpServletRequest req)  {
		 Classs  classs = new  Classs();
		if (req.getParameter("name") != null && req.getParameter("name").trim().length() > 0){
			 classs.setName(req.getParameter("name"));}
		if(req.getParameter("type")!= null && req.getParameter("type").trim().length()>0){
				classs.setType(req.getParameter("type"));
		}
		if(req.getParameter("openTime")!= null && req.getParameter("openTime").trim().length()>0){
			try {
				classs.setOpenTime( new   SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("openTime")) );
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
		return  classs;

	}

}
