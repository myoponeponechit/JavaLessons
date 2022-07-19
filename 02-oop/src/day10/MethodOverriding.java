package day10;

public class MethodOverriding {
	
	public static void main(String[] args) {
		System.out.println("--- Method Overriding ---");
		var cat = new Cat();
		cat.display(); // child's method
		cat.show(); // super's method
		cat.sound(); // child's method
		
		System.out.println("-----------");
		var ani = new Animal();
		ani.sound(); // animal's sound
		
		System.out.println("-----------");
		ani = new Cat();
		ani.sound(); // cat's sound
		
		System.out.println("--- Method Overloading ---");
		var cat1 = new Cat();
		cat1.display();
		cat1.display("ShweWar");
	}
}
class Animal {
	void show() {
		System.out.println("This is show method");
	}
	
	void sound() { // overriden method
		System.out.println("Some sound");
	}
}

class Cat extends Animal {
	void display() { // overloaded method
		System.out.println("It is a cat");
	}
	
	void display(String name) { // overloading method
		System.out.println("It's name is " + name);
	}
	
	@Override
	void sound() { // overriding method
		System.out.println("Myung");
	}
}
