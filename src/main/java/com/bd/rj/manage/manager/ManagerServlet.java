package com.bd.rj.manage.manager;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") // 压缩警告
@WebServlet(urlPatterns = "/manage/manager.do", asyncSupported = true, initParams = {
		@WebInitParam(name = "username", value = "root"), @WebInitParam(name = "password", value = "root"),
		@WebInitParam(name = "drivername", value = "com.mysql.jdbc.Driver"),
		@WebInitParam(name = "url", value = "jdbc:mysql://.......") })
public class ManagerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method=request.getParameter("method");
		System.out.println("method:"+method);
		
		
		//1.获取异步对象
		 AsyncContext ac = request.startAsync();
		 
		 //2.多线程任务类
		 ThreadTask threadTask=new ThreadTask(ac);
		
		
		 //3.设定一个超时的时间
		 ac.setTimeout(200);
		 
		 //4.开启
		 ac.start(threadTask);
		
		 
		 //5.主线程继续做自己喜欢做的事
		 request.getRequestDispatcher("/jsps/list.jsp").forward(request, response);
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet启动预加载的一些数据username："+getServletConfig().getInitParameter("username"));
		System.out.println("servlet启动预加载的一些数据password："+getServletConfig().getInitParameter("password"));
	}

}
