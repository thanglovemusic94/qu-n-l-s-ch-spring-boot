package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Category;
import com.springboot.repository.CategoryRepository;
import com.springboot.vo.CategoryVo;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository repository;
	
	@Override
	public List<CategoryVo> getAllCategory() {
		List<Category> categories = repository.getAllCategory();
		List<CategoryVo> categoryVos = new ArrayList<>();
		
		for(Category category : categories) {
			CategoryVo vo = new CategoryVo();
			vo.setId(category.getId());
			vo.setName(category.getName());
			
			categoryVos.add(vo);
		}
		return categoryVos;
	}
	
	@Override
	public boolean createCategory(CategoryVo vo) {
		try {
		Category entity = new Category();
		entity.setId(vo.getId());
		entity.setName(vo.getName());
		repository.save(entity);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	@Override
	public boolean deleteCategory(String id) {
		try {
			repository.deleteById(id);
			return true;
		}catch (PersistenceException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	@Override
	public boolean updateCategory(CategoryVo vo) {
		try {
			Category category = repository.getOne(vo.getId());
			category.setName(vo.getName());
			
			repository.save(category);
			return true;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Category getCategoryById(String id) {
		return repository.getOne(id);
	}

	@Override
	public List<Category> getCategory() {
		return (List<Category>) repository.findAll();
	}

	
	

}
