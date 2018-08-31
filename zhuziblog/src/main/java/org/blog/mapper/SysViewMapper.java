package org.blog.mapper;

import java.util.List;

import org.blog.entity.SysView;

public interface SysViewMapper {

	void addView(SysView sysView);
	
	List<SysView> listAllSysView();

}
