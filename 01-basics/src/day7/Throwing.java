package day7;

import java.util.Scanner;

public class Throwing {
	
	static void checkMark(int mark) {
		if(mark > 100 || mark < 0) {
//			ArithmeticException obj = new ArithmeticException("Invalid mark");
//			throw obj;
			throw new ArithmeticException("Invalid mark");
		}
		else {
			System.out.println("Your mark: " + mark);
		}
	}
	public static void main(String[] args) {
		try {
			//checkMark(-1);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter mark: ");
			int mark = sc.nextInt();
			checkMark(mark);
			sc.close();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}
}
