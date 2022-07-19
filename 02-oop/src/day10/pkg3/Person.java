package day10.pkg3;

public class Person {
	private String name;
	
	public Person() {
		
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	void showData() {
		System.out.println("Name: " + name);
	}
}
