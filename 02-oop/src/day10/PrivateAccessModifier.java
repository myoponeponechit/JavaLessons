package day10;

public class PrivateAccessModifier {
	
	private int number = 100;
	
	void test() {
		//private int num = 20; // invalid modifier because of within class
		System.out.println(number);
	}
}

class B{
	void test() {
		var obj = new PrivateAccessModifier();
		// obj.number = 22; // error (private)
	}
}
