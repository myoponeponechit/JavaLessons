package day5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment2 {

	 public static void main(String[] args) {
		String[] townships = {"AA", "BB", "CC", "DD"};
		int[] times = {15, 30, 10, 45};
		String[] menus = {"Pizza", "Burger", "Milk Tea", "Spicy Noodle"};
		Scanner sc = new Scanner(System.in);
		
		// show menus
		System.out.println("****** Available Menus ******");
		int length = menus.length;
		for(var i = 0; i < length; i++) {
			System.out.println("   " + (i + 1) + ". " + menus[i]);
		}
		System.out.print("Please choose item: ");
		int choose = Integer.parseInt(sc.nextLine());
		if(choose > length || choose == 0) {
			System.out.print("You can choose 1 to 4, Please choose item: ");
			choose = Integer.parseInt(sc.nextLine());
		}
		
		// delivery servic
		System.out.println("\n****** Deliverable Township ******");
		int town_length = townships.length;
		int times_length = times.length;
		for(var j = 0; j < town_length; j++) {
				System.out.println("   " + (j + 1) + ". " + townships[j] + " (" + times[j] + " mins)");
		}
		System.out.print("Please choose township: ");
		int choose_town = Integer.parseInt(sc.nextLine());
		if(choose_town > town_length || choose_town == 0) {
			System.out.print("You can choose 1 to 4, Please choose township: ");
			choose_town = Integer.parseInt(sc.nextLine());
		}
		
		//chosen order type
		System.out.println("\n****** Order Type ******");
		System.out.println("   1. Order now?");
		System.out.println("   2. Preorder?");
		System.out.print("Please choose 1 or 2: ");
		int order = Integer.parseInt(sc.nextLine());
		int choose_order = 0;
		if(order == 1 || order == 2) {
			if(order == 1) {
				choose_order = 1;
			}
			else {
				choose_order = 2;
			}
		}
		else {
			System.out.print("You can choose only 1 or 2: ");
			order = Integer.parseInt(sc.nextLine());
			if(order == 1 || order == 2) {
				if(order == 1) {
					choose_order = 1;
				}
				else {
					choose_order = 2;
				}
			}
		}
		
		// order now and preorder
		if(choose_order == 1) {
			LocalTime order_times = LocalTime.now();
			DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm:ss a");
			int order_times_min = order_times.getMinute();
			
			System.err.println("\nCurrent times: " + order_times.format(f));
			int arrival_times = order_times_min + times[choose_town-1];
			
			System.out.println("\n****** Your Order Information ******");
			System.out.println("   Item name: " + menus[choose-1]);
			System.out.println("   Your address: " + townships[choose_town-1]);
			System.out.println("   Duration: " + times[choose_town-1] + " mins");

			if(arrival_times >= 60) {
				int change = arrival_times/60;
				int hour = order_times.getHour() + change;
				int min = arrival_times%60;
				LocalTime output = LocalTime.of(hour, min);
				System.out.println("   Arrival time: " + output.format(f));
			}
			else {
				LocalTime order_arrival = LocalTime.of(order_times.getHour(), arrival_times);
				System.out.println("   Arrival time: " + order_arrival.format(f));
			}
			System.out.println("******** Thank you for your ordering ********");
		}
		else if(choose_order == 2) {
			LocalDate today = LocalDate.now();
			System.err.println("\nCurrent date: " + today);
			
			DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy mm dd");
			DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd");
			int date;
			
			System.out.print("\nEnter deliver date (dd): ");
			date = Integer.parseInt(sc.nextLine());
			
			while(date > 31 || date == 0) {
				System.out.print("\nPlease enter deliver date (dd) between 1-31: ");
				date = Integer.parseInt(sc.nextLine());
				
			}
			System.out.println("****** Your Order Information ******");
			System.out.println("   Item name: " + menus[choose-1]);
			System.out.println("   Your address: " + townships[choose_town-1]);
			
			int day = Integer.parseInt(today.format(f2));
			
			LocalDate arr_date1 = LocalDate.of(today.getYear(), today.getMonthValue()+1, date);
			String day_of_week1 = arr_date1.getDayOfWeek().toString().substring(0, 3);
			LocalDate arr_date2 = LocalDate.of(today.getYear(), today.getMonthValue(), date);
			String day_of_week2 = arr_date2.getDayOfWeek().toString().substring(0, 3);
			
			if(date < day) {
				System.out.println("   Arrival date: " + day_of_week1 + LocalDate.of(today.getYear(), today.getMonthValue()+1, date));
			}
			else {
				System.out.println("   Arrival date: " + day_of_week2 + ", " + LocalDate.of(today.getYear(), today.getMonthValue(), date));
			}
			System.out.println("******** Thank you for your ordering ********");
		}
		
		
		// close
		sc.close();
	}
}
