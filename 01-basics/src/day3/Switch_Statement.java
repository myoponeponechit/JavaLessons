package day3;

import java.util.Scanner;

public class Switch_Statement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter food name : ");
		String name = sc.nextLine();
		String category;
		switch(name) {
		case "burger", "pizza", "sandwich" :
			category = "Fast Food";
			break;

		case "yogurt", "milk tea" :
			category = "Dessert";
			break;
			
		case "mohinga" :
			category = "Burmese Food";
			break;
			
		case "sushi" :
			category = "Japanese Food";
			break;
			
		default:
			category = "Unknown";
		}
		
		System.out.println(name + " is " + category);
	}
}
