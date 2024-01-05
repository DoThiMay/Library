package com.springmvc.library1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Carddetails")
public class Carddetail {
	@Id
    @Column(name = "cardID")
	private String cardID;
	private String bookID;
	private String status;
	public Carddetail() {}
	public Carddetail(String cardID, String bookID, String status) {
		super();
		this.cardID = cardID;
		this.bookID = bookID;
		this.status = status;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
