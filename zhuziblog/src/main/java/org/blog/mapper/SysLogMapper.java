package org.blog.mapper;

import java.util.List;

import org.blog.entity.SysLog;

public interface SysLogMapper {
	void addLog(SysLog sysLog);

	List<SysLog> listAllSysLog();
}
