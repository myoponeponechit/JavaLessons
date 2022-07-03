package day2;

import java.util.Scanner;
import day1.Introduction;

public class ConstVariable {
	
	static final float RATE = 2.5f;
	static final float MIN_PRICE = 1000f;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter price : ");
		float price = sc.nextInt();
		if(price < MIN_PRICE) {
			price = MIN_PRICE;
		}
		
		System.out.println("Price : " + price);
		System.out.println("Expense : " + (price * RATE));
		//RATE = 3.5f; // can't change because it is const
		
		Introduction obj;
	}
}
