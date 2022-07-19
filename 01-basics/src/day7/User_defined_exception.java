package day7;

import java.util.Scanner;

public class User_defined_exception {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter age: ");
			int age = sc.nextInt();
			validateAge(age);
		}
		catch (InvalidAgeException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void validateAge(int age) throws InvalidAgeException {
		if(age < 18) {
			throw new InvalidAgeException("Age must be at least 18.");
		}
		else {
			System.out.println("You can smoke!");
		}
	}
}
class InvalidAgeException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidAgeException(String msg) {
		super(msg);
	}
	public InvalidAgeException() {
		
	}
}