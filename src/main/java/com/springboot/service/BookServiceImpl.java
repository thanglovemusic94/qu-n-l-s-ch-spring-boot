package com.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Book;
import com.springboot.entities.Category;
import com.springboot.repository.BookRepository;
import com.springboot.repository.CategoryRepository;
import com.springboot.vo.BookVo;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Book> getAllBook() {
		return repository.findAll();
	}
	
	@Override
	public boolean createBook(BookVo vo) {
		boolean result = false;
		try {
			Book book = new Book();
			book.setName(vo.getName());
			book.setImg(vo.getImg().getOriginalFilename());
			book.setTacgia(vo.getTacgia());
			book.setTheloai(vo.getTheloai());
			book.setNxb(vo.getNxb());
			book.setNgay(vo.getNgay());
			book.setChitiet(vo.getChitiet());
			Category category= categoryRepository.findCategoryById(vo.getCategory().getId());
			book.setCategory(category);
			repository.save(book);
			result = true;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean deleteBook(Integer id) {
		if(id != null) {
			repository.deleteBookById(id);
			return true;
		}
		return false;
	}
	
	
	@Override
	public Book getBookById(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public Book save(Book book) {
		return repository.save(book);
	}
	
	@Override
	public Book update(Book book) {
		return repository.save(book);
	}

	
	
	
}
