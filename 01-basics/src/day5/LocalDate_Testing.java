package day5;

import java.time.LocalDate;

public class LocalDate_Testing {
	
	public static void main(String[] args) {
		// create date object
		LocalDate today = LocalDate.now();
		LocalDate date2 = LocalDate.of(2016, 9, 23);
		LocalDate date3 = LocalDate.parse("2009-05-10");
		
		System.out.println("Today: " + today);
		System.out.println("Tomorrow: " + today.plusDays(1));
		System.out.println("Yesterday: " + today.minusDays(1));
		System.out.println("Date2: " + date2);
		System.out.println("Date3: " + date3);
		
		System.out.println("Current year: " + today.getYear());
		System.out.println("Current month value: " + today.getMonthValue());
		System.out.println("Current month: " + today.getMonth()); // return enum type
		System.out.println("Current day of week: " + today.getDayOfWeek()); // return enum type
		System.out.println("Current day of month: " + today.getDayOfMonth());
		
		System.out.println(today + " is leap year: " + today.isLeapYear());
		System.out.println(date2 + " is leap year: " + date2.isLeapYear());
		
		System.out.println(today + " is equal " + date2 + ": " + today.equals(date2));
	}
}
