package com.mmit.model.entity;

import java.time.LocalDate;

public class Book {
	
	private int code;
	private String title;
	private LocalDate publishDate;
	private Category category;
	private Author author;
	private Librarian lib;
	private Boolean available;
	
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public Category getCategory() {
		return category;
	}
	public String getCategoryName() {
		return category.getName();
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Author getAuthor() {
		return author;
	}
	public String getAuthorName() {
		return author.getName();
	}
	public void setAuthor(Author author) {
		this.author = author;
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
