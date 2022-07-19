package day10.pkg1;

public class A {
	
	int number = 100; // default or package modifier
	protected String name;
	public int age;
	
	void test() {
		System.out.println(number); // ok because of within class
		System.out.println(name); // ok because of within class
		System.out.println(age);
	}
}
