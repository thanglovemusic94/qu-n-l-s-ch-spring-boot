package com.springboot.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ManagerVo implements Serializable{
	@NotBlank(message="Mã tài khoản không được để trống")
	@Column(name="idmanager")
	private String id;
	
	@NotBlank(message="Mật khẩu không được để trống")
	@Column(name="pass")
	private String pass;
	
	@NotBlank(message="Tên quản lý không được để trống")
	@Column(name="ten")
	private String ten;
	
	@NotBlank(message="Năm sinh không được để trống")
	@Column(name="namsinh")
	private String namsinh;
	
	@NotBlank(message="Email không được để trống")
	@Column(name="email")
	private String email;
	
	@NotBlank(message="Số điện thoại không được để trống")
	@Column(name="sdt")
	private String sdt;
	
	@NotBlank(message="Địa chỉ không được để trống")
	@Column(name="diachi")
	private String diachi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	

}
