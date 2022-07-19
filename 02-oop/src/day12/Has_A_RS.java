package day12;

public class Has_A_RS {
	public static void main(String[] args) {
		Author author = new Author("Mya Than Tint", "Myaing");
		Book book = new Book("War and Peace", 10000, author);
		
		System.out.println("Book Name: " + book.name);
		System.out.println("Book Price: " + book.price);
		System.out.println("--- Author Detail ---");
		System.out.println("Author Name: " + book.author.name);
		System.out.println("Township: " + book.author.nativeTown);
	}
}

class Author {
	String name;
	String nativeTown;
	
	public Author(String name, String town) {
		this.name = name;
		this.nativeTown = town;
	}
}

class Book {
	String name;
	int price;
	Author author;
	
	public Book(String name, int price, Author auth) {
		this.name = name;
		this.price = price;
		this.author = auth;
	}
}
