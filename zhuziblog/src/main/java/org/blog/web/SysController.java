package org.blog.web;

import java.util.List;

import org.blog.entity.SysLog;
import org.blog.entity.SysView;
import org.blog.service.SysService;
import org.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/admin")
public class SysController {

	@Autowired
	SysService sysService;
	// 对应管理页面数据统计-访问统计页面
	@RequestMapping(value = "/statisticManagement", method = RequestMethod.GET)
	public String statisticManagement(Model model,Page page) {
		PageHelper.offsetPage(page.getStart(), 5);
		List<SysView> listAllSysView = sysService.listAllSysView();
		int total  = (int) new PageInfo<>(listAllSysView).getTotal();
		page.calculateLast(total);
		model.addAttribute("listAllSysView", listAllSysView);
		return "statisticManagement";
	}
	
	// 对应管理页面数据统计-访问统计页面
	@RequestMapping(value = "/statisticLogManagement", method = RequestMethod.GET)
	public String statisticLogManagement(Model model,Page page) {
		PageHelper.offsetPage(page.getStart(), 5);
		List<SysLog> listAllSysLog = sysService.listAllSysLog();
		System.out.println(listAllSysLog.get(0));
		int total  = (int) new PageInfo<>(listAllSysLog).getTotal();
		page.calculateLast(total);
		model.addAttribute("listAllSysLog", listAllSysLog);
		return "statisticLogManagement";
	}
	
	//增加一条系统日志记录
	@RequestMapping(value="/sys/log",method=RequestMethod.GET)
	public String sysListAllLog(SysView sysView,Model model) {
		sysService.addView(sysView);
		return "redirect:statisticManagement";
	}
}
