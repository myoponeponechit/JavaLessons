package com.mmit.model.entity;

import java.time.LocalDate;

public class Transaction {
	
	private int id;
	private Member member; // cardId;
	private Book book; // bookId;
	private LocalDate borrowDate;
	private LocalDate dueDate;
	private double fees;
	private Librarian lib; // libId
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public int getCardId() {
		return member.getCardId();
	}
	public String getName() {
		return member.getName();
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public void setCardId(Member cardId) {
		this.member = cardId;
	}
	public Book getBook() {
		return book;
	}
	public int getBookCode() {
		return book.getCode();
	}
	public String getBookTitle() {
		return book.getTitle();
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setBookCode(Book bookCode) {
		this.book = bookCode;
	}
	public void setBookTitle(Book bookTitle) {
		this.book = bookTitle;
	}
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public Librarian getLib() {
		return lib;
	}
	public String getEntryBy() {
		return lib.getEmail();
	}
	public void setLib(Librarian lib) {
		this.lib = lib;
	}
	public void setEntryBy(Librarian entryBy) {
		this.lib = entryBy;
	}
	
}
