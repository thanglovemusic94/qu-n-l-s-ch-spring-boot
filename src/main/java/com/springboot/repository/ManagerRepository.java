package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String>{

	final String SELECT_ALL = "SELECT m FROM Manager m";
	final String SELECT_BY_ID = "SELECT m FROM Manager m WHERE m.id =:idmanager";
	
	@Query(SELECT_ALL)
	List<Manager> getAllManager();
	
	@Query(SELECT_BY_ID)
	Manager findManagerById(@Param("idmanager") String id);
	
}
