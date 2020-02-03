package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
	final String SELECT_ALL = "SELECT c FROM Category c";
	final String SELECT_BY_ID = "SELECT c FROM Category c WHERE c.id=:idcategory";

	@Query(SELECT_ALL)
	List<Category> getAllCategory();
	
	@Query(SELECT_BY_ID)
	Category findCategoryById(@Param("idcategory") String id);

}
