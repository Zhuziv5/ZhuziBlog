package org.blog.service.impl;

import java.util.List;

import org.blog.entity.SysLog;
import org.blog.entity.SysView;
import org.blog.mapper.SysLogMapper;
import org.blog.mapper.SysViewMapper;
import org.blog.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysServiceImpl implements SysService{

	@Autowired
	SysViewMapper sysViewMapper;
	
	@Autowired
	SysLogMapper sysLogMapper;
	/**
	 * 增加一条访问量
	 */
	@Override
	public void addView(SysView sysView) {
		sysViewMapper.addView(sysView);
	}

	/**
	 * 增加一条日志信息
	 */
	@Override
	public void addLog(SysLog sysLog) {
		sysLogMapper.addLog(sysLog);
	}

	/**
	 * 获取所有日志
	 */
	@Override
	public List<SysLog> listAllSysLog() {
		return sysLogMapper.listAllSysLog();
	}

	/**
	 * 获取所有访问
	 */
	@Override
	public List<SysView> listAllSysView() {
		return sysViewMapper.listAllSysView();
	}

}
