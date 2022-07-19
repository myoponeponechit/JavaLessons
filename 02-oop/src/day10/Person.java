package day10;

// public class Person extends Object // (default extends)
public class Person{
	
	private String name;
	protected String phone;
	
	// name = "Cherry", phone = "9592567809"
	public Person(String name, String phone) {
		super(); // In public class Person,it had default extends(extends Object).so, super() is need.
		this.name = name; // name = "Cherry"
		this.phone = phone; // phone = "9592567809"
	}
	
	void display() {
		System.out.println("Name - " + name);
		System.out.println("Phone - " + phone);
	}
}
