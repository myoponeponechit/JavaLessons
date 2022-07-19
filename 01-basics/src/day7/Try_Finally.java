package day7;

import java.util.Scanner;

public class Try_Finally {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = null; // NullPointerException
		try {
			System.out.println("Enter salary: ");
			int salary = sc.nextInt();
			if(salary == 0) {
				return;
			}
			System.out.println("Your salary: " + salary);
		}
		catch (NullPointerException e) {
			System.err.println("Object does not allocate in memory!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Finally block execute.");
			sc.close();
		}
		System.out.println("Outside of try finally block.");
	}
}
