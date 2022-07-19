package day9;

import java.time.LocalDate;

public class CopyConstructor {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1961, 10, 16);
		Book book1 = new Book("Detective U San Shar", date , 6000);
		System.out.println(book1);
		Book book2 = new Book(book1); // copy constructor
		System.out.println("\n---- Book2 ----");
		System.out.println(book2);
		
		changePrice(book2);
		System.out.println("\nAfter change, price: " + book2.price);
		
		int a = 100;
		changeValue(a);
		System.out.println("\nAfter change, a: " + a);
	}

	private static void changeValue(int b) {
		b = 300;
	}

	private static void changePrice(Book book2) {
		book2.price = 10000;
		
	}
}

class Book{
	String title;
	LocalDate publishdate;
	int price;
	
	public Book(String title, LocalDate p_date, int price) {
		this.title = title;
		this.publishdate = p_date;
		this.price = price;
	}
	
	public Book(Book obj) { // copy constructor(access object data)
		this.title = obj.title;
		this.publishdate = obj.publishdate;
		this.price = obj.price;
	}
	
	@Override
	public String toString() {
		return "Title: " + this.title +
				",\nPublish Date: " + this.publishdate +
				",\nPrice: " + this.price + " ks";
	}
}
