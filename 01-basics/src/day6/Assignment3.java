package day6;

import java.util.Scanner;

public class Assignment3 {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			String nrcno;
			String[] division = {"Kachin", "Kayar", "Kayin", "Chin", "Sagaing", "Tanintharyi", "Bago", "Magway", "Mandalay", "Mon", "Rakhine", "Yangon", "Shan", "Ayeyawady"};
			//System.out.println(division.length);
			System.out.print("Enter your NRC number: ");
			nrcno = sc.nextLine();
			//System.out.println(nrcno);
			
			// display division
			int index = Integer.parseInt(nrcno.substring(0, nrcno.indexOf("/")));
			System.out.println("Division/State: " + division[index-1]);
			
			// display township
			String township = nrcno.substring(nrcno.indexOf("/") + 1, nrcno.indexOf("("));
			System.out.println("Township: " + township);
			
			// display NRC no
			String number = nrcno.substring(nrcno.indexOf(")") + 1);
			System.out.println("Number: " + number);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Invalid Division or State");
		}
	}
}
