package filter;
/*
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

import managedBeans.UserBean;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println(" url = " + ((HttpServletRequest) servletRequest).getRequestURL());

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		UserBean identity = (UserBean) request.getSession().getAttribute("identity");

		if ((identity != null && identity.getLoggedInAsDeveloperOrScrumMaster() == true)
				|| (request.getRequestURL().toString().contains("login.jsf"))) {
			filterChain.doFilter(request, response);
		}

		else {
			response.sendRedirect(request.getContextPath() + "/login.jsf");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}


*/