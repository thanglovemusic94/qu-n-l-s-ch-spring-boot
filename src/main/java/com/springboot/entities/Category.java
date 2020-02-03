package com.springboot.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable{
	 @Id
	 @Column(name="idcategory")
		private String id;
		
	 @Column(name="namecategory")
		private String name;
		
	 @OneToMany(mappedBy="category")
		private List<Book> books;


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public List<Book> getBooks() {
			return books;
		}


		public void setBooks(List<Book> books) {
			this.books = books;
		}


		public Category(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		
		}


		public Category() {
			
		}
		
		
}
