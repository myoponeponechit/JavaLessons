package day4;

import java.util.Scanner;

public class Assignment1 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("How many numbers you want to type : ");
			int num = sc.nextInt();	
			var count_zero = 0;
			var count_positive = 0;
			var count_negative = 0;
			for(var i = 0; i < num; i++) {
				System.out.print("Enter any number : ");
				int number = sc.nextInt();
				if(number == 0) {
					count_zero += 1;
				}
				else if(number > 0) {
					count_positive += 1;
				}
				else if(number < 0) {
					count_negative += 1;
				}
			}
			//close
			sc.close();
			System.out.println("_____________________________\n");
			System.out.println("Number of zero : " + count_zero);
			System.out.println("Number of positive : " + count_positive);
			System.out.println("Number of negative : " + count_negative);
		}
}
