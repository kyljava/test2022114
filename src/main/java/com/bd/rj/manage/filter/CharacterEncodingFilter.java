package com.bd.rj.manage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(filterName = "CharacterEncodingFilter",
urlPatterns = "/manage/*",
initParams = {@WebInitParam(name = "sex", value = "girl")}
		)
public class CharacterEncodingFilter  implements Filter  {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 System.out.println("init()......");
		 
		 System.out.println("过滤器初始化预加载的一些数据:"+filterConfig.getInitParameter("sex"));
		 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 System.out.println("doFilter()......");
	}

	@Override
	public void destroy() {   
		 System.out.println("destroy()......");
	}

}