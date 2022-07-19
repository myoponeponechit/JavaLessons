package day10.pkg1;

public class B {
	void test() {
		var obj = new A();
		obj.number = 200; // ok because of within same pkg
		obj.name = "Cherry"; // ok because of within same pkg
		obj.age = 22; // ok because of within same pkg
	}
}

class C extends A{ // can be inherited to the subclass
	// int number 
	// protected String name
	// public int age
	void test() {
		System.out.println(number);
		System.out.println(name);
		System.out.println(age);
	}
}