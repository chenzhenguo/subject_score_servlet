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
import cn.sxt.service.StudentService;
import cn.sxt.service.impl.StudentServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Student;

@WebServlet("/stu")
public class StudentServlet extends HttpServlet {
	StudentService stuService = new StudentServiceImpl();
	Student student = new Student();

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

	

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		try {
			System.out.println("update>>>>>>>");
		Student stu = new Student();
		if(req.getParameter("id")!= null)
			stu.setId(Integer.parseInt(req.getParameter("id")));
		if(req.getParameter("age")!=null)
			stu.setAge(Integer.parseInt(req.getParameter("age")));
			stu.setName(req.getParameter("name"));
			if(req.getParameter("sex")!=null)
			stu.setSex(Integer.parseInt(req.getParameter("sex")));
			if(req.getParameter("statusId")!=null)
			stu.setStatusId(Integer.parseInt(req.getParameter("statusId")));
			stu.setIdCard(req.getParameter("idCard"));
			stu.setPhone(req.getParameter("phone"));
			stu.setMayor(req.getParameter("mayor"));
			stu.setEducation(req.getParameter("education"));
			stu.setSchool(req.getParameter("school"));
			stu.setAddress(req.getParameter("address"));
			if(req.getParameter("hireDate")!=null)
			stu.setHireDate(new SimpleDateFormat( "yyyy-MM-dd").parse(req.getParameter("hireDate")) );
				int i =	stuService.update(stu);
				if(i>0){
					System.out.println("修改成功");
				}else{
					System.out.println("修改失败");
				}
				
				if(i>0){
					try {
						resp.sendRedirect("stu");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		
	}



	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String  id=	req.getParameter("id");
		if(id!= null){
			int studentId=Integer.parseInt(id);
			student.setId(studentId);
			stuService.delete(student);
			resp.sendRedirect(req.getContextPath()+"/jsp/success.jsp");
		}
		
		
	}



	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			System.out.println("add>>>>>>>");
		Student stu = new Student();
		if(req.getParameter("id")!= null)
			stu.setId(Integer.parseInt(req.getParameter("id")));
		if(req.getParameter("age")!=null)
			stu.setAge(Integer.parseInt(req.getParameter("age")));
			stu.setName(req.getParameter("name"));
			if(req.getParameter("sex")!=null)
			stu.setSex(Integer.parseInt(req.getParameter("sex")));
			if(req.getParameter("statusId")!=null)
			stu.setStatusId(Integer.parseInt(req.getParameter("statusId")));
			stu.setIdCard(req.getParameter("idCard"));
			stu.setPhone(req.getParameter("phone"));
			stu.setMayor(req.getParameter("mayor"));
			stu.setEducation(req.getParameter("education"));
			stu.setSchool(req.getParameter("school"));
			stu.setAddress(req.getParameter("address"));
			if(req.getParameter("hireDate")!=null)
			stu.setHireDate(new SimpleDateFormat( "yyyy-MM-dd").parse(req.getParameter("hireDate")) );
				int i =	stuService.add(stu);
				if(i>0){
					System.out.println("添加成功");
				}else{
					System.out.println("添加失败");
				}
				
				if(i>0){
					try {
						resp.sendRedirect(req.getContextPath()+"/jsp/success.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					resp.sendRedirect(req.getContextPath()+"/jsp/erro.jsp");
				}
		
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		 
		
	}



	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Student stu= new Student();
				int id = Integer.parseInt(req.getParameter("id"));
				
				Student st=	stuService.getById(id);
				
			
				req.setAttribute("student", st);
			
					req.getRequestDispatcher("/jsp/student/toUpdate.jsp").forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				};
		
		
	}



	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 开始封装条件.当条件查询调用该方法时,会传一个studentBean的对象,通过调用对象中的数据,列出列表
		PageUtil page = new PageUtil();
		StudentBean sb = condition(req);
		// 总记录数---为了前台的分页显示 ,在pageUtil中设置总记录数,数据通过stuService中的方法获得
		page.setTotalCount(stuService.totalCount(sb));
		// 获取主页面的currentPage 当前页面的值,并判断是否为空,如果为空则默认为第一页,弱国不为空,主页面点击下一页时会在当前页加一
		String currPage = req.getParameter("currentPage");
		int currentPage = 1;

		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
			if (currentPage < 1) {
				currentPage = 1;
			}
			if (currentPage > page.getTotalPage()){
				currentPage = page.getTotalPage();
			}
		}
		page.setCurrentPage(currentPage);
		// 把stuService 调用list的功能,列出当前页面
		
		System.out.println("当前页"+page.getCurrentPage());
		System.out.println("总页"+page.getTotalPage());
		
		System.out.println(page.getPageSize());
		req.setAttribute("list", stuService.list(page, sb));
		req.setAttribute("page", page);
		req.setAttribute("sb", sb);
			req.getRequestDispatcher("jsp/student/students.jsp").forward(req,resp);
	
	}

	private StudentBean condition(HttpServletRequest req) {
		StudentBean sb = new StudentBean();
		if (req.getParameter("name") != null
				&& req.getParameter("name").trim().length() > 0)
			sb.setName(req.getParameter("name"));

		if (req.getParameter("age") != null
				&& req.getParameter("age").trim().length() > 0)
			sb.setAge(Integer.parseInt(req.getParameter("age")));

		if (req.getParameter("className") != null
				&& req.getParameter("className").trim().length() > 0)
			sb.setClassName(req.getParameter("className"));

		if (req.getParameter("phone") != null
				&& req.getParameter("phone").trim().length() > 0)
			sb.setPhone(req.getParameter("phone"));

		if (req.getParameter("education") != null
				&& req.getParameter("education").trim().length() > 0)
			sb.setEducation(req.getParameter("education"));

		if (req.getParameter("school") != null
				&& req.getParameter("school").trim().length() > 0)
			sb.setSchool(req.getParameter("school"));

		if (req.getParameter("mayor") != null
				&& req.getParameter("mayor").trim().length() > 0)
			sb.setMayor(req.getParameter("mayor"));

		if (req.getParameter("hireDate") != null
				&& req.getParameter("hireDate").trim().length() > 0)
			sb.setHireDate(req.getParameter("hireDate"));
		return sb;

	}

}
