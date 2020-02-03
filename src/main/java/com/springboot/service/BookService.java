package com.springboot.service;

import java.util.List;

import com.springboot.entities.Book;
import com.springboot.vo.BookVo;

public interface BookService {
	List<Book> getAllBook();
	
	public boolean createBook(BookVo vo);
	
	public boolean deleteBook(Integer id);
	
	
	
	public Book getBookById(Integer id);

	Book save(Book book);
	
	Book update(Book book);
	
}
