package day9;

public class CallingSuperConstructor {
	
	public static void main(String[] args) {
		Teacher t = new Teacher("U Zaw Zaw", "Tutor");
	}
}

class Employee {
	private String name;
	public Employee() {
		
	}
	public Employee(String name) {
		this.name = name;
		System.out.println("This is emp constructor");
	}
}

class Teacher extends Employee {
	private String position;
	public Teacher(String na, String pos) {
		super(na);
		this.position = pos;
		System.out.println("This is teacher constructor");
	}
}
