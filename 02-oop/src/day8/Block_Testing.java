package day8;

public class Block_Testing {
	static int min_length;
	String phone;
	
	public Block_Testing(String input) {
		System.out.println("This is one argument constructor.");
		this.phone = input;
	}
	
	public Block_Testing () {
		System.out.println("This is default constructor.");
	}
	
	{ // instance block
		System.out.println("This is instance block.");
		phone = "Invalid Number";
	}
	
	static { // static block
		System.out.println("This is static block.");
		min_length = 11;
	}
	
	public static void main(String[] args) {
		Block_Testing obj1 = new Block_Testing("09265948");
		System.out.println("Object1: " + obj1.phone);
		
		System.out.println("-------------");
		
		Block_Testing obj2 = new Block_Testing();
		System.out.println("Object2: " + obj2.phone);
	}
}
