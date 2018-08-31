package org.blog.service;

import java.util.List;

import org.blog.entity.SysLog;
import org.blog.entity.SysView;

public interface SysService {

	void addView(SysView sysView);
	void addLog(SysLog sysLog);
	List<SysLog> listAllSysLog();
	List<SysView> listAllSysView();
}
