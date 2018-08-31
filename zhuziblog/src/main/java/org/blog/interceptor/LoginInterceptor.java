package org.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.blog.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private static String username = "xxz";
	private static String password = "123456";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = true;
		System.out.println("进入后台拦截器成功！");
//		HttpSession session=request.getSession();
//		 System.out.println(session.isNew());
		User user = (User) request.getSession().getAttribute("user");
		if (null == user) {
			// 如果用户为空则跳转到error页面
			// 2018年6月29日20:23:05：修改sendRedirect方法为getRequestDispatcher，
			// 目的是保证地址栏不改变（与前台错误页面响应一致），这样用户就不知道后台页面的地址
			System.out.println("进入user为空");
//			request.getRequestDispatcher("/error.html").forward(request, response);
			response.sendRedirect("/zhuziblog/login.html");
			flag = false;
		} else {
			// 对用户账号进行验证,是否正确
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               System.out.println("访问后台API");
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}