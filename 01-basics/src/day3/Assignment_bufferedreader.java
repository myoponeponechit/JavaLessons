package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment_bufferedreader {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Input
		System.out.println("Enter fullname : ");
		String name = reader.readLine();
		System.out.println("Enter email : ");
		String email = reader.readLine();
		System.out.println("Enter phone no : ");
		String phone = reader.readLine();
		System.out.println("Enter education : ");
		String education = reader.readLine();
		System.out.println("Enter salary : ");
		Double salary = Double.parseDouble(reader.readLine());
		System.out.println("Enter age : ");
		int age = Integer.parseInt(reader.readLine());
		
		reader.close();
		
		//Display
		System.out.println("\n--------- Your Profile ----------");
		System.out.println("Fullname : " + name);
		System.out.println("Email : " + email);
		System.out.println("Phone : " + phone);
		System.out.println("Education : " + education);
		System.out.println("Income : " + salary);
		System.out.println("Age : " + age);
	}

}
