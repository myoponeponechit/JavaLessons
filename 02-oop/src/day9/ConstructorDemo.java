package day9;

class Person {
	
	String name;
	int age;
	boolean single;
	
	// default constructor
	public Person() {
		name = "Unknown";
		age = 100;
		single = true;
	}
	// parameterized constructor
	public Person(String name, int age, boolean status) {
		this.name = name;
		this.age = age;
		this.single = status;
	}
	
	// display
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Is single: " + ((single == true) ? "yes" : "no"));
	}
}

public class ConstructorDemo{
	public static void main(String[] args) {
		System.out.println("---- with default constructor overwrite ----");
		Person p1 = new Person();
		// p1.name = "Unknown"   // default value of string is null in java
		// p1.age = 100   // default value of integer is 0.
		// p1.single = true   // default value of boolean is false.
		p1.display();
		System.out.println();
		
		Person p2 = new Person();
		// p2.name = "Unknown"
		// p2.age = 100
		// p2.single = true
		p2.display();
		System.out.println();
		
		System.out.println("---- with parameter constructor ----");
		Person p3 = new Person("Aung Aung", 22, true);
		// p3.name = "Aung Aung",
		// p3.age = 22,
		// p3.single = true
		p3.display();
		System.out.println();
		
		var p4 = new Person("Cherry", 19, false);
		// p4.name = "Cherry",
		// p4.age = 19,
		// p4.single = false
		p4.display();
	}
}
