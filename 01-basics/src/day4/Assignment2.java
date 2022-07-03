package day4;

import java.util.Scanner;

public class Assignment2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text;
		do {
			System.out.print("Enter your time that go to bed : ");
			int bed_time = sc.nextInt();
			System.out.print("Enter your time that wake up : ");
			int wake_up_time = sc.nextInt();
			int total_sleep_time = (12 - bed_time) + wake_up_time;
			//System.out.println("Total sleep time : " + total_sleep_time + " hours");
			//total_sleep_time > 5 && total_sleep_time < 8 => You take care your health well!
			//total_sleep_time < 5 => Yor are very hardworking!	
			//total_sleep_time > 8 => You are abnormal!
			
			if(total_sleep_time < 5) {
				System.out.println("Yor are very hardworking!");
			}
			else if(total_sleep_time > 5 && total_sleep_time <= 8) {
				System.out.println("You take care your health well!");
			}
			else if(total_sleep_time > 8) {
				System.out.println("You are abnormal!");
			}
			System.out.println("");
			System.out.print("If you want to exit, enter 'exit' : ");
			text = sc.next();
			System.out.println("-----------------------------------------");
		}while(!(text.equalsIgnoreCase("exit")));
		//close
		sc.close();
	}
}
