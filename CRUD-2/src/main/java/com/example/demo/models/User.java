package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // đánh dấu là 1 thực thể của jpa
//@GeneratedValue tự động tạo giá trị
@Table(name="users")//mapping đến bảng users trong database
public class User implements Serializable{
    @Id
    @Column(name="username",length=50)//cột tương ứng trong database
	private String username;
    @Column(name="password",length=50)
	private String password;
    @Column(name="fullname",length=50)
	private String fullname;
    @Column(name="age")
	private Integer age;
    @Column(name="gender")
	private boolean geander;
	public User() {
		super();
	}
	public User(String username, String password, String fullname, Integer age, boolean geander) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.age = age;
		this.geander = geander;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isGeander() {
		return geander;
	}
	public void setGeander(boolean geander) {
		this.geander = geander;
	}
	
	
	
}
