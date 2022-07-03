package day3;

import java.util.Scanner;

public class ConditionalStatement {
	public static void main(String[] args) {
		//if statement
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter language : ");
//		String lang = sc.nextLine();
//		
//		if(lang.equalsIgnoreCase("Java")) { // java = Java
//			System.out.println("Best programming language");
//		}
		
		//if else statement
//		System.out.println("-------if else--------");
//		System.out.println("Enter email : ");
//		String email = sc.nextLine();
//		System.out.println("Enter password : ");
//		String password = sc.nextLine();
//		
//		if(email.equals("admin@gmail.com") && password.equals("12345")) {
//			System.out.println("Login Success!");
//		}
//		else {
//			System.err.println("Email and password don't match!");
//		}
		
		//if else if statement
		System.out.println("Enter your BMI : ");
		float bmi = sc.nextFloat();
		if(bmi < 18.5) {
			System.out.println("Underweight!");
		}
		else if(bmi >= 18.5 && bmi <= 24.9) {
			System.out.println("Normal Weight!");
		}
		else if(bmi >=25 && bmi <= 29.9) {
			System.out.println("Over Weight!");
		}
		else if(bmi >= 30) {
			System.out.println("Obesity!");
		}
		
		sc.close();
	}
}
