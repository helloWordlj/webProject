package com.lujun.frame.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.lujun.frame.common.WebContent;

public class TestFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter");
		chain.doFilter(req,rep);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		System.out.println("init");
		ServletContext sct = fc.getServletContext();
		String CONTEXT_PATH = WebContent.CONTEXT_PATH;
		sct.setAttribute(CONTEXT_PATH, sct.getContextPath());
	}

}
