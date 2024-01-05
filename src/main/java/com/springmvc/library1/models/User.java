package com.springmvc.library1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "userID")
	private String userID;
	@Column(name = "userName")
	private String userName;
	private String phone;
	private String address;
	private String gender;
	public User() {}
	public User(String userID, String userName, String phone, String address, String gender) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}	
	
}
