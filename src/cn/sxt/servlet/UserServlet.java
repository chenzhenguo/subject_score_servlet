package cn.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sxt.service.UserService;
import cn.sxt.service.impl.UserServiceImpl;
import cn.sxt.vo.User;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String action = req.getParameter("action");
			if(action==null||"login".equals(action)){
				login(req,resp);
			}else if("logout".equals(action)){
				logout(req,resp);
			}
			

		
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			req.getSession().removeAttribute("currentUser");
			resp.sendRedirect("jsp/login.jsp");
		
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String code=req.getParameter("code");
		
		
		//忽略大小写验证验证码是否正确
		if(!((String) req.getSession().getAttribute("code")).equalsIgnoreCase(code)){
			
			req.setAttribute("msg", "验证码不正确");
			req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
			return;
		}	

		
		
		String name =req.getParameter("name");
		String pwd = req.getParameter("pwd");
		User user = new User(name,pwd);
		User temp=   userService.login(user);
		if(temp!= null ){
			//登陆成功,进入主界面
		
				HttpSession session =	req.getSession();
					session.setAttribute("currentUser", temp);
					resp.sendRedirect("jsp/index.jsp");
		}else{
			//登录失败 ,返回登陆页面
			resp.sendRedirect("jsp/login.jsp");
		}
		
		
		
		
		
		
	}
}
