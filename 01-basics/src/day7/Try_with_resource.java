package day7;

import java.util.Scanner;

public class Try_with_resource {
	
	public static void main(String[] args) {
		
		System.out.println("------ Try with resource statement ------");
		try(Scanner s = new Scanner(System.in)) {
			System.out.print("Enter name: ");
			System.out.println("Your name: " + s.nextLine());
		}
		catch (Exception obj) {
			System.err.println(obj.getMessage());
		}
	}
}
// try with resource method auto closed Scanner(s.closed) after try block have executed
// try(Scanner s = new Scanner(System.in);multiple...)