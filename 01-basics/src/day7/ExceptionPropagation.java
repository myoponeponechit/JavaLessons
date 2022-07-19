package day7;

public class ExceptionPropagation {
	
	public static void main(String[] args) {
		test3(); // 4.ArithmeticException
	}

	private static void test3() {
		test2(); // 3.ArithmeticException
	}

	private static void test2() {
		test1(); // 2.ArithmeticException
	}

	private static void test1() {
		System.out.println(100/0); // 1.ArithmeticException because of devisor is 0
	}
}
