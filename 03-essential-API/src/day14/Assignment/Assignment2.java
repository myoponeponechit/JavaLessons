package day14.Assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {
	
	static List<String> categoryList = new ArrayList<>();
	static List<Author> authorList = new ArrayList<>();
	static List<Book> bookList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// initialize data
		initializeData();
		try(Scanner sc = new Scanner(System.in)) {
			// show all
			String output = """
					1. View Author
					2. View Category
					3. View Book
					4. Add New Book
					Choose number(1 ~ 4): 
					""";
			System.out.print(output);
			int input = Integer.parseInt(sc.nextLine());
			
			switch (input) {
			case 1: {
				viewAuthor();
				break;
			}
			case 2: {
				viewCategory();
				break;
			}
			case 3: {
				viewBook(sc);
				break;
			}
			case 4: {
				addBook(sc);
				break;
			}
			default:
				System.err.println("Invalid number!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();		}
		
	}

	

	// Add new book
	private static void addBook(Scanner sc) {
		System.out.println("---- Add new book ----");
		System.out.println("Enter book code: ");// 123846
		int code = Integer.parseInt(sc.nextLine());
		System.out.println("Enter book title: ");
		String title = sc.nextLine();
		System.out.println("Enter category: ");
		String category = sc.nextLine();
		System.out.println("Enter author name: ");
		String name = sc.nextLine();
		System.out.println("Enter country: ");
		String country = sc.nextLine();
		System.out.println("Enter publish date: ");
		String date = sc.nextLine();
		LocalDate p_date = LocalDate.parse(date);
		sc.close();
		addingNewBook(code, title, category, p_date, name, country);
	}

	private static void addingNewBook(int code, String title, String category, LocalDate p_date, String name,
			String country) {
		var book = new Book();
		if(code==1001 || code==1002 || code==1003 || code==1004 || code==1006 || code == 1008) {
			System.err.println("This book code has already exist.");
		}
		else {
			book.setCode(code);
			book.setTitle(title);
			int len = categoryList.size();
			for(var k = 0; k < len; k++) {
				if(categoryList.get(k).equalsIgnoreCase(category)) {
					book.setCategory(categoryList.get(k));
					break;
				}
				else {
					categoryList.add(category);
					break;
				}
			}
			//System.out.println(categoryList);
			book.setCategory(categoryList.get(len));
				
			book.setPublishDate(p_date);
			int size = authorList.size();
			for(var j = 0; j < size; j++) {
				if(authorList.get(j).getName().equalsIgnoreCase(name)) {
					book.setAuthor(authorList.get(j));
					break;
				}
				else {
					authorList.add(new Author(name, country));
					book.setAuthor(authorList.get(size));
					break;
				}
			}
				
			bookList.add(book);
			viewAllBook();
		}
	}
		



	// View Book
	private static void viewBook(Scanner sc) {
		
		String output = """
				1. View All
				2. View by Category
				3. View by Author
				Choose number(1 ~ 3):
				""";
		System.out.println(output);
		int input = Integer.parseInt(sc.nextLine());
		if(input == 1) {
			viewAllBook();
		}
		else if(input == 2) {
			System.out.print("Enter category name: ");
			String name = sc.nextLine();
			viewByCategory(name);
		}
		else if(input == 3) {
			System.out.print("Enter author name: ");
			String name = sc.nextLine();
			viewByAuthor(name);
		}
		else {
			System.err.println("Invalid number!");
		}
	}


	private static void viewByAuthor(String name) {
		
		Author author = null;
		for(var auth : authorList) {
			if(auth.getName().equalsIgnoreCase(name)) {
				author = auth;
				break;
			}
		}
		
		if(author == null) {
			System.err.println(name + " does not exiat");
		}
		else {
			var result_list = new ArrayList<Book>();
			for(var b : bookList) {
				if(b.getAuthor().getName().equalsIgnoreCase(name)) {
					result_list.add(b);
				}
			}
			if(result_list.size() > 0) { // found
				System.out.println("Code\t|Book Title\t|Category\t|Publish Date");
				System.out.println("--------+---------------+---------------+-------------");
				result_list.forEach(obj -> {
					System.out.print(obj.getCode() + "\t|");
					System.out.print(obj.getTitle() + "\t|");
					System.out.print(obj.getCategory() + "\t\t|");
					System.out.print(obj.getPublishDate() + "\n");
				});
			}
			else {
				System.out.println("There is no book related to this author.");
			}
		}
		
	}

	
	
	private static void viewAllBook() {
		System.out.println("-------------- Book List --------------");
		System.out.println("\nCode\t|Book Title\t|Category\t|Author\t\t|Publish Date");
		System.out.println("--------+---------------+---------------+---------------+------------");
		bookList.forEach(obj -> {
			System.out.print(obj.getCode() + "\t|");
			System.out.print(obj.getTitle() + "\t|");
			System.out.print(obj.getCategory() + "\t\t|");
			System.out.print(obj.getAuthor().getName() + "\t\t|");
			System.out.print(obj.getPublishDate() + "\n");;
		});
		
	}

	
	
	private static void viewByCategory(String name) {
		String category = null;
		for(var cate: categoryList) {
			if(cate.equalsIgnoreCase(name)) {
				category = cate;
				break;
			}
		}
		
		if(category == null) {
			System.err.println(name + " does not exiat in category list");
		}
		else {
			var result_list = new ArrayList<Book>();
			for(var b : bookList) {
				if(b.getCategory().equalsIgnoreCase(name)) {
					result_list.add(b);
				}
			}
			if(result_list.size() > 0) { // found
				System.out.println("Code\t|Book Title\t|Author\t\t|Publish Date");
				System.out.println("--------+---------------+---------------+-------------");
				result_list.forEach(obj -> {
					System.out.print(obj.getCode() + "\t|");
					System.out.print(obj.getTitle() + "\t|");
					System.out.print(obj.getAuthor().getName() + "\t\t|");
					System.out.print(obj.getPublishDate() + "\n");
				});
			}
			else {
				System.out.println("There is no book related to this category.");
			}
		}
		
	}



	// View Category
	private static void viewCategory() {
		System.out.println("----- Category List -----");
		int lan = categoryList.size();
		for(var i = 0; i < lan; i++) {
			System.out.println((i+1) + ". " + categoryList.get(i));
		}
		
	}


	// View Author
	private static void viewAuthor() {
		System.out.println("----- Author list -----");
		System.out.println("\nName\t|\tCountry");
		System.out.println("--------+----------------");
		authorList.forEach(obj -> {
			System.out.println(obj.getName() + "\t|\t" + obj.getCountry());
		});
		
	}


	// Initialize Data
	private static void initializeData() {
		
		// category
		categoryList.add("music");
		categoryList.add("movie");
		categoryList.add("cosmetic");
		categoryList.add("drinks");
		categoryList.add("comdy");
		
		// author
		authorList.add(new Author("Kim", "Korea"));
		authorList.add(new Author("Jeon", "India"));
		authorList.add(new Author("Cherry", "Myanmar"));
		authorList.add(new Author("Jue", "Myanmar"));
		authorList.add(new Author("James", "Thailand"));
		authorList.add(new Author("Leo", "China"));
		
		// book
		var book1 = new Book();
		book1.setCategory(categoryList.get(0));
		book1.setAuthor(authorList.get(0));
		book1.setCode(1001);
		book1.setPublishDate(LocalDate.of(2019, 10, 29));
		book1.setTitle("No more drame");
		
		var book2 = new Book();
		book2.setCategory(categoryList.get(1));
		book2.setAuthor(authorList.get(0));
		book2.setCode(1002);
		book2.setPublishDate(LocalDate.of(2018, 5, 8));
		book2.setTitle("Life is gone");
		
		var book3 = new Book();
		book3.setCategory(categoryList.get(0));
		book3.setAuthor(authorList.get(2));
		book3.setCode(1003);
		book3.setPublishDate(LocalDate.of(2011, 5, 8));
		book3.setTitle("In the rain");
		
		var book4 = new Book();
		book4.setCategory(categoryList.get(4));
		book4.setAuthor(authorList.get(2));
		book4.setCode(1008);
		book4.setPublishDate(LocalDate.of(2020, 8, 18));
		book4.setTitle("Beautiful girl");
		
		var book5 = new Book();
		book5.setCategory(categoryList.get(4));
		book5.setAuthor(authorList.get(3));
		book5.setCode(1004);
		book5.setPublishDate(LocalDate.of(2015, 9, 10));
		book5.setTitle("Sky Light");
		
		var book6 = new Book();
		book6.setCategory(categoryList.get(3));
		book6.setAuthor(authorList.get(4));
		book6.setCode(1006);
		book6.setPublishDate(LocalDate.of(2019, 10, 10));
		book6.setTitle("Home alone");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		bookList.add(book5);
		bookList.add(book6);
	}
}
