package day5;


//import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Period_Duration {
	
	public static void main(String[] args) {
		LocalDate start_date = LocalDate.parse("2019-09-25");
		LocalDate end_date = LocalDate.parse("2021-10-31");
		
		int month = Period.between(start_date, end_date).getMonths();
		System.out.println("Number of month : " + month);
		System.out.println("Number of days: " + Period.between(start_date, end_date).getDays());
		System.out.println("Number of years: " + Period.between(start_date, end_date).getYears());
		
		// local time
		LocalTime time1 = LocalTime.parse("11:30");
		LocalTime time2 = LocalTime.parse("12:00");
		
		//System.out.println("No of sec: " + Duration.between(time1, time2).getSeconds()); // error
	}
}
