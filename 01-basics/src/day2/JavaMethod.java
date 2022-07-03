package day2;

public class JavaMethod {
	
	int num1 =20; // instance field
	static int num2 = 30; // static field
	
	void instance_method() {
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
	}
	static void static_method() {
		// cannot access
		//System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		}
	public static void main(String[] args) {
//		Demo obj = new Demo();
//		obj.instance_method();
//		Demo.static_method();
	}
}
