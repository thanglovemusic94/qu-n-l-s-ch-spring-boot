package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	final String SELECT_ALL ="SELECT b FROM Book b";
	
	final String DELETE_BOOK_BY_ID = "DELETE FROM Book b WHERE b.id =:id";
	
	final String SELECT_BY_ID = "SELECT b FROM Book b WHERE b.id=:id";
	
	@Query(SELECT_ALL)
	List<Book> getAllBook();
	
	@Query(SELECT_BY_ID)
	Book findBookById(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query(DELETE_BOOK_BY_ID)
	void deleteBookById(@Param("id") Integer id);
	
}
