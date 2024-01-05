package com.springmvc.library1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Book")
public class Book {
	@Id
    @Column(name = "bookID")
	private String bookID;
	@Column(name = "bookName")
	private String bookName;
	private String author;
	private Date year;
	private int price;
	private int number;
	public Book(String bookID, String bookName, String author, Date year, int price, int number) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.year = year;
		this.price = price;
		this.number = number;
	}
	public Book() {
		
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
		
}