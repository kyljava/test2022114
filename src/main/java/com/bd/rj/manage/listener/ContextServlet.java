package com.bd.rj.manage.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ContextServlet implements  ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	System.out.println("上下文内容初始化了");
	
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("上下文内容初销毁了");
	
	}


}
