package cn.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.bean.PointBean;
import cn.sxt.service.PointsService;
import cn.sxt.service.impl.PointsServiceImpl;
import cn.sxt.util.PageUtil;

@WebServlet("/points")
public class PointsServlet extends HttpServlet {

	private PointsService pntService = new PointsServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action == null || "list".equals(action)) {
			list(req, resp);
		}

	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 封装查询条件
		PointBean pb = condition(req);
		PageUtil pu = new PageUtil();
		pu.setTotalCount(pntService.totalCount(pb));
		String currPage = req.getParameter("currentPage");
		int currentPage = 1;
		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
			if (currentPage < 1) {
				currentPage = 1;
			}
			if (currentPage >= pu.getTotalPage()) {
				currentPage = pu.getTotalPage();
				System.out.println("pu.getTotalPage()"+pu.getTotalPage());
			}

		}
		pu.setCurrentPage(currentPage);

		req.setAttribute("list", pntService.list(pu, pb));
		req.setAttribute("pb", pb);
		req.setAttribute("page", pu);
		req.getRequestDispatcher("jsp/points/points.jsp").forward(req, resp);

	}

	private PointBean condition(HttpServletRequest req) {
		PointBean pb = new PointBean();
		if (req.getParameter("name") != null
				&& req.getParameter("name").trim().length() > 0)
			pb.setName(req.getParameter("name"));
		if (req.getParameter("age") != null
				&& (req.getParameter("age").trim().length() > 0))
			pb.setAge(Integer.parseInt(req.getParameter("age")));
		if (req.getParameter("score") != null
				&& (req.getParameter("score").trim().length() > 0))
			pb.setAge(Integer.parseInt(req.getParameter("score")));
		if (req.getParameter("className") != null
				&& req.getParameter("className").trim().length() > 0)
			pb.setClassName(req.getParameter("className"));
		if (req.getParameter("phone") != null
				&& req.getParameter("phone").trim().length() > 0)
			pb.setPhone(req.getParameter("phone"));
		if (req.getParameter("education") != null
				&& req.getParameter("education").trim().length() > 0)
			pb.setEducation(req.getParameter("education"));
		if (req.getParameter("school") != null
				&& req.getParameter("school").trim().length() > 0)
			pb.setSchool(req.getParameter("school"));
		if (req.getParameter("mayor") != null
				&& req.getParameter("mayor").trim().length() > 0)
			pb.setMayor(req.getParameter("mayor"));
		if (req.getParameter("hireDate") != null
				&& req.getParameter("hireDate").trim().length() > 0)
			pb.setHireDate(req.getParameter("hireDate"));
		return pb;
	}
}
