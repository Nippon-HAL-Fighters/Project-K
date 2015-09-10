package jp.ac.hal.tokyo.nippon_hal_fighters.service;

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

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter", urlPatterns="/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq  = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;

		String reqURL   = httpReq.getRequestURL().toString();
		String reqFile  = reqURL.substring(reqURL.lastIndexOf("/") + 1);
		String fileType = reqFile.substring(reqFile.lastIndexOf(".") + 1);

		if (reqFile.equals("login.jsp") || (!fileType.equals("html") && !fileType.equals("jsp") && !reqFile.isEmpty())) {
			chain.doFilter(request, response);
			return;
		}

		if (!UserUtil.isLogin(httpReq)) {
			httpRes.sendRedirect("./login.jsp");

			return;
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
