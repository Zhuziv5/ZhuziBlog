package org.blog.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.blog.entity.SysLog;
import org.blog.entity.SysView;
import org.blog.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class VisitInterceptor implements HandlerInterceptor {

	@Autowired
	SysService sysService;

	private SysLog sysLog = new SysLog();
	private SysView sysView = new SysView();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入了Visit拦截器！");
		// 访问者的ip
		String ip = request.getRemoteAddr();

		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		System.out.println(ip);
			// 访问地址
			String url = request.getRequestURI().toString();
			System.out.println(url);
			// 给SysLog增加记录
			sysLog.setIp(ip);
			sysLog.setOperateUrl(url);
			
			// 增加访问量
			sysView.setIp(ip);
			System.out.println(sysView.getIp());
			if(session.isNew()) {
			sysService.addView(sysView);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("已进入visit的postHandle中");
		if (handler instanceof HandlerMethod) {
			System.out.println("已进入visit的postHandle的if中");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 保存日志信息
            sysLog.setRemark(method.getName());
            sysService.addLog(sysLog);

        } else {
        	System.out.println("已进入visit的postHandle的else中");
            String uri = request.getRequestURI();
            sysLog.setRemark(uri);
            sysService.addLog(sysLog);
        }
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
