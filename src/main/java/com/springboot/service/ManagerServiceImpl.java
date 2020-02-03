package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Manager;
import com.springboot.repository.ManagerRepository;
import com.springboot.vo.ManagerVo;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerRepository repository;

	@Override
	public List<ManagerVo> getAllManager() {
		List<Manager> managers = repository.getAllManager();
		List<ManagerVo> managerVos = new ArrayList<>();
		
		for(Manager manager : managers) {
			ManagerVo vo = new ManagerVo();
			vo.setId(manager.getId());
			vo.setPass(manager.getPass());
			vo.setTen(manager.getTen());
			vo.setNamsinh(manager.getNamsinh());
			vo.setEmail(manager.getEmail());
			vo.setSdt(manager.getSdt());
			vo.setDiachi(manager.getDiachi());
			
			managerVos.add(vo);
		}
		return managerVos;
	}

	@Override
	public boolean createManager(ManagerVo vo) {
		try {
		Manager entity = new Manager();
		entity.setId(vo.getId());
		entity.setPass(vo.getPass());
		entity.setTen(vo.getTen());
		entity.setNamsinh(vo.getNamsinh());
		entity.setEmail(vo.getEmail());
		entity.setSdt(vo.getSdt());
		entity.setDiachi(vo.getDiachi());
		repository.save(entity);
		return true;
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteManager(String id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateManager(ManagerVo vo) {
		try {
			Manager manager = repository.getOne(vo.getId());
			manager.setPass(vo.getPass());
			manager.setTen(vo.getTen());
			manager.setNamsinh(vo.getNamsinh());
			manager.setEmail(vo.getEmail());
			manager.setSdt(vo.getSdt());
			manager.setDiachi(vo.getDiachi());
			
			repository.save(manager);
			return true;
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Manager getManagerById(String id) {
		
		return repository.getOne(id);
	}

	@Override
	public List<Manager> getManager() {
		
		return (List<Manager>) repository.findAll();
	}
	
	
}
