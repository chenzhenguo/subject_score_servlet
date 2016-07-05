package cn.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sxt.service.SubjectService;
import cn.sxt.service.impl.SubjectServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Subject;

@WebServlet("/subject")
public class SubjectServlet extends HttpServlet{
	private SubjectService subjectService = new  SubjectServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action==null||"list".equals(action)){
			list(req,resp);
		}
		/*else if("toAdd".equals(action)){
			toAdd(req,resp);
		}else if("add".equals(action)){
			add(req,resp);
		}else if("delete".equals(action)){
			delete(req,resp);
		}else if("toUpdate".equals(action)){
			toUpdate(req,resp);
		}else if("update".equals(action)){
			update(req,resp);
		}*/
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//封装查询条件
		Subject subject = new Subject();
		if(req.getParameter("name")!=null&&req.getParameter("name").trim().length()>0){
			subject.setName(req.getParameter("name"));
		}
		
		PageUtil pu = new PageUtil();
		//总记录数---主要为了前台的分页显示
		pu.setTotalCount(subjectService.totalCount(subject));
		String currPage=req.getParameter("currentPage");
		int currentPage=1;
		if(currPage!=null){
			currentPage=Integer.parseInt(currPage);
			if(currentPage<1){
				currentPage=1;
			}
			if(currentPage>pu.getTotalPage()){
				currentPage=pu.getTotalPage();
			}
		}
		//指定当前页
		pu.setCurrentPage(currentPage);
		//查询出指定页的数据
		req.setAttribute("list", subjectService.list(pu,subject));
		req.setAttribute("subject", subject);
		req.setAttribute("page", pu);
		req.getRequestDispatcher("jsp/subject/subject.jsp").forward(req, resp);
	}
}
