package day3;

import java.util.Scanner;

public class Assignment_scanner {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter fullname : ");
		String name = sc.nextLine();
		System.out.println("Enter email : ");
		String email = sc.nextLine();
		System.out.println("Enter phone no : ");
		String phone = sc.nextLine();
		System.out.println("Enter education : ");
		String education = sc.nextLine();
		System.out.println("Enter income : ");
		Double income = Double.parseDouble(sc.nextLine());
		System.out.println("Enter age : ");
		int age = Integer.parseInt(sc.nextLine());
		
		sc.close();
		
		System.out.println("\n-------- Your Profile --------");
		System.out.println("Name : " + name);
		System.out.println("Email : " + email);
		System.out.println("Phone : " + phone);
		System.out.println("Education : " + education);
		System.out.println("Income : " + income);
		System.out.println("Age : " + age);
	}

}
