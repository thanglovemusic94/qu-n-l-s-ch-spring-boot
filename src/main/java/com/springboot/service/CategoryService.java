package com.springboot.service;

import java.util.List;

import com.springboot.entities.Category;
import com.springboot.vo.CategoryVo;


public interface CategoryService {
	public List<CategoryVo> getAllCategory();
	
	public boolean createCategory(CategoryVo vo);
	
	public boolean deleteCategory(String id);
	
	public boolean updateCategory(CategoryVo vo);
	
	public Category getCategoryById(String id);
	
	public List<Category> getCategory();
}
