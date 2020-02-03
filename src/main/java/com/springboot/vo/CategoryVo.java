package com.springboot.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


public class CategoryVo  implements Serializable{
	@NotBlank(message="Mã danh mục không được để trống!")
	@Column(name="idcategory")
	private String id;
	
	@NotBlank(message = "Tên danh mục không được để trống!")
	@Column(name="namecategory")
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<BookVo> booksVo;

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

	public List<BookVo> getBooksVo() {
		return booksVo;
	}

	public void setBooksVo(List<BookVo> booksVo) {
		this.booksVo = booksVo;
	}

}
