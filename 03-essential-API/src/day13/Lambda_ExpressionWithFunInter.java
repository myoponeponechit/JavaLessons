package day13;

public class Lambda_ExpressionWithFunInter {
	public static void main(String[] args) {
		// MyInterface1
		System.out.println("--- Using with concrete class ---");
		MyInterface1 inter1 = new MyClass();
		inter1.display("Aung Aung");
		
		System.out.println("\n--- Using with anony inner class ---");
		MyInterface1 inter2 = new MyInterface1() {
			
			@Override
			public void display(String name) {
				System.out.println("Name: " + name);
			}
		};
		inter2.display("Cherry");
		
		System.out.println("\n--- Using with Lambda Expression ---");
		MyInterface1 inter3 = (str)-> System.out.println("Name: " + str);
		inter3.display("James");
		
		// MyInterface2
//		System.out.println("\n--- Using with anony inner class ---");
//		MyInterface2 add = new MyInterface2() {
//			
//			@Override
//			public int operate(int a, int b) {
//				// TODO Auto-generated method stub
//				return a + b;
//			}
//		};
//		MyInterface2 sub = new MyInterface2() {
//			
//			@Override
//			public int operate(int a, int b) {
//				// TODO Auto-generated method stub
//				return a - b;
//			}
//		};
//		MyInterface2 mul = new MyInterface2() {
//			
//			@Override
//			public int operate(int a, int b) {
//				// TODO Auto-generated method stub
//				return a * b;
//			}
//		};
//		MyInterface2 div = new MyInterface2() {
//			
//			@Override
//			public int operate(int a, int b) {
//				// TODO Auto-generated method stub
//				return a / b;
//			}
//		};
//		System.out.println("100 + 200 = " + add.operate(100, 200));
//		System.out.println("490 - 230 = " + sub.operate(490, 230));
//		System.out.println("34 * 87 = " + mul.operate(34, 87));
//		System.out.println("580 / 12 = " + div.operate(580, 12));
		
		System.out.println("\n--- Using with Lambda Expression ---");
		MyInterface2 add = (a, b)-> a + b;
		MyInterface2 sub = (n1, n2)-> n1 - n2; 
		MyInterface2 mul = (a, b)-> a * b;
		MyInterface2 div = (n1, n2)-> n1 / n2;
		
		System.out.println("100 + 200 = " + add.operate(100, 200));
		System.out.println("490 - 230 = " + sub.operate(490, 230));
		System.out.println("34 * 87 = " + mul.operate(34, 87));
		System.out.println("580 / 12 = " + div.operate(580, 12));
		
		// MyInterface3
		MyInterface3 obj = (name, pass) -> {
			if(name.equalsIgnoreCase("admin") && pass.equals("123"))
				return true;
			else
				return false;
		};
		System.out.println("\nLogin: " + ((obj.checkLogin("admin", "123")) ? "Success" : "Fail"));
		System.out.println("Login: " + ((obj.checkLogin("cherry", "125")) ? "Success" : "Fail"));
	}
}

@FunctionalInterface
interface MyInterface1 {
	void display(String name);
}

interface MyInterface2 {
	int operate(int a, int b);
}

interface MyInterface3 {
	boolean checkLogin(String uname, String pass);
}

class MyClass implements MyInterface1{

	@Override
	public void display(String name) {
		System.out.println("Name: " + name);
	}
}