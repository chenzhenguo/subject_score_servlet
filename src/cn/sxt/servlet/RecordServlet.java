package cn.sxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.sxt.service.RecordService;
import cn.sxt.service.impl.RecordServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Record;

@WebServlet("/record")
public class RecordServlet extends HttpServlet {
	private RecordService rsService = new RecordServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null || "list".equals(action)) {
			list(req, resp);
		}

	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		PageUtil pu = new PageUtil();
		pu.setTotalCount(rsService.totalCout(sid));
		String currPage = req.getParameter("currentPage");
		int currentPage = 1;
		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
			if (currentPage <= 1) {
				currentPage = 1;
				if (currentPage >= pu.getTotalCount()) {
					currentPage = pu.getTotalCount();
				}
			}
		}
		pu.setCurrentPage(currentPage);
		List<Record> list =rsService.list(pu,sid);
		Map<String,Object> map=new HashMap<String ,Object>();
		map.put("list", list);
		map.put("page", pu);
		map.put("sid", sid);
		PrintWriter out = resp.getWriter();
		out.print(new Gson().toJson(map));
		

	}

}
