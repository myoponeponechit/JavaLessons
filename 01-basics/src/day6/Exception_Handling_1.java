package day6;

import java.util.Scanner;

public class Exception_Handling_1 {

		public static void main(String[] args) {
			try {
				Scanner sc = new Scanner(System.in);
				//Scanner sc = null; // NullPointerExceptionError
				System.out.print("Enter num1: ");
				int num1 = Integer.parseInt(sc.nextLine());
				System.out.print("Enter num2: ");
				int num2 = Integer.parseInt(sc.nextLine());
				
				int result = num1 / num2;
				System.out.println("Result is " + result);
				
				sc.close();
			}
			catch(ArithmeticException e){ // execute when exception occur in try
				System.err.println("Divisor must not be '0'!");
			}
			catch (NumberFormatException e) {
				System.err.println("User input is not a number!");
			}
			catch(Exception e) { // can handle its subclass 
				System.err.println(e.getMessage());
			}
			
			System.out.println("Outside try catch block");
		}
}  
//	in this program, have only two statements
//	1.-> try catch ststement
//	2.-> syso statement
 