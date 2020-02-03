package com.springboot.service;

import java.util.List;

import com.springboot.entities.Manager;
import com.springboot.vo.ManagerVo;

public interface ManagerService {
	public List<ManagerVo> getAllManager();
	
	public boolean createManager(ManagerVo vo);
	
	public boolean deleteManager(String id);
	
	public boolean updateManager(ManagerVo vo);
	
	public Manager getManagerById(String id);
	
	public List<Manager> getManager();
}
