package com.springmvc.library1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Librarycard")
public class Librarycard {
	@Id
    @Column(name = "cardID")
	private String cardID;
	private String userID;
	private Date borrowedday;
	private Date payday;
	public Librarycard() {}
	public Librarycard(String cardID, String userID, Date borrowedday, Date payday) {
		super();
		this.cardID = cardID;
		this.userID = userID;
		this.borrowedday = borrowedday;
		this.payday = payday;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getBorrowedday() {
		return borrowedday;
	}
	public void setBorrowedday(Date borrowedday) {
		this.borrowedday = borrowedday;
	}
	public Date getPayday() {
		return payday;
	}
	public void setPayday(Date payday) {
		this.payday = payday;
	}
	
}
