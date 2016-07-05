package cn.sxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("����");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// �� filter�� ���� �� ���� ����Ӧ ת��ΪHttpServlet���������Ӧ
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// ��ȡsession��ֵ,�ж��Ƿ�Ϊ��,��Ϊ��,����Ӧ����¼ҳ��
		HttpSession session = req.getSession();
		// �ж�
		String url = req.getRequestURI();
		System.out.println("url>>>" + url);
		if (url.endsWith("image.jsp")||url.endsWith(".png")||url.endsWith("login.jsp")||url.endsWith(".js") ||url.endsWith(".css")|| url.endsWith("login.jsp") || (url.endsWith("user") && "login".equals(req .getParameter("action")))) {
			chain.doFilter(request, response);

		} else {
			if (session.getAttribute("currentUser") == null) {
				// �û�δ��½
				resp.sendRedirect("jsp/login.jsp");
			} else {
				chain.doFilter(request, response);
			}

		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��ʼ��");

	}

}
