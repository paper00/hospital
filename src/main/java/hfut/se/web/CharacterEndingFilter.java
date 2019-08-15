package hfut.se.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharacterEndingFilter implements Filter {
	
	public CharacterEndingFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		String encoding = config.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);	
		
		chain.doFilter(req, response);
	}
	
	private FilterConfig config;
	
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
