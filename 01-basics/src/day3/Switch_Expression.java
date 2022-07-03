package day3;

import java.util.Scanner;

public class Switch_Expression {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		System.out.println("Enter food name : ");
		var name = sc.nextLine();
		
//		var category = 
//				switch(name){
//					case "burger", "pizza", "sandwich" -> "Fast Food";
//					case "milk tea", "yogurt" -> "Dessert";
//					case "mohinga" -> "Burmese Food";
//					case "sushi" -> "Japanese Food";
//					default -> "unknown";
//				};
		var category = 
				switch(name) {
				case "burger", "pizza", "sandwich" -> {
						if(name.equals("pizza"))
							System.out.println(name + " is italian food");
						yield "Fast Food";
					}
				case "yogurt", "milk tea" -> {
					yield "Dessert";
				}
				case "mohinga" -> "Burmese Food";
				default -> throw new IllegalArgumentException("Unexpected value: " + name);
				};
		System.out.println(name + " is " + category);
	}
}
