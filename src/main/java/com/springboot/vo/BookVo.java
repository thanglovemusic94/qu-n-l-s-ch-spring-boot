package com.springboot.vo;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.entities.Category;

public class BookVo implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	
	@NotBlank(message="Tên sách không được để trống!")
	private String name;
	
//	private MultipartFile[] img;
	private MultipartFile img;
	
	@NotBlank(message="Tên tác giả không được để trống!")
	private String tacgia;
	
	@NotBlank(message="Tên thể loại không được để trống!")
	private String theloai;
	
	@NotBlank(message="Tên NBX không được để trống!")
	private String nxb;
	
	@NotBlank(message="Ngày cập nhật không được để trống!")
	private String ngay;
	
	@NotBlank(message="Mô tả chi tiết không được để trống!")
	private String chitiet;
	
	
	@ManyToOne
	@JoinColumn(name="idcategory")
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

	public String getNxb() {
		return nxb;
	}

	public void setNxb(String nxb) {
		this.nxb = nxb;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getChitiet() {
		return chitiet;
	}

	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
