package day5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Assignment1 {
	
	public static void main(String[] args) {
		String[] weekdays = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
		//String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		LocalDate date = LocalDate.now();
		//LocalDate date = LocalDate.of(2022, 7, 10);
		var today = date.getDayOfWeek();
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
		String day = today.toString();
		int l = weekdays.length;
		int result = -1;
		for(var j = 0; j < l; j++) {
			if(weekdays[j].equalsIgnoreCase(day)) {
				result = j;
				break;
			}
		}
//		System.out.println(day.substring(0,3) + ", " + date.format(f1));
//		System.out.println("\n***********************");
		if(result >= 0) {
			String week_day = weekdays[result].substring(0,3);
			System.out.println(week_day + ", " + date.format(f1));
			System.out.println("\n***********************");
			System.out.println("I have no time. I am studying Programming Language.");
		}
		else {
			System.out.println(day.substring(0,3) + ", " + date.format(f1));
			System.out.println("\n***********************");
			System.out.println("Today is my holiday!");
		}
	}
}
