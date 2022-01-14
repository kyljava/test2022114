package com.bd.rj.manage.manager;


import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @desc   多线程任务类：目的是利用这个新的线程发送邮件的
 * @author wyh
 * @time   2022-01-10
 */
public class ThreadTask  implements Runnable {
public AsyncContext ac=null;//目的是利用servlet3.x中的异常对象获取request,session，进而实现异步发送耗时的邮件
	
	
	
public ThreadTask(AsyncContext ac)
{
this.ac = ac;
}



	@Override
	public void run()
	{
	
		try {
			System.out.println("异步处理开始的时间："+System.currentTimeMillis());	
			 //1.通过ac获取request对象
			HttpServletRequest request=(HttpServletRequest) ac.getRequest();
			
			//2.通过request对象获取session对象
			HttpSession session = request.getSession();
				
			//3.模拟一个耗时操作
			Thread.sleep(8000);
			
			//4.将信息存入到session中
			session.setAttribute("message", "邮件已经发送了");
			
			System.out.println("异步处理结果的时间"+System.currentTimeMillis());
			
		} 
		catch (InterruptedException e) 
		{
			System.out.println("中断异常....");
		}
		catch (IllegalStateException e)
		{
			ac.dispatch("/jsps/show.jsp");
		}	
			
		
		
		
	}

}
