package day14.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Assignment1 {
	
	public static void main(String[] args) {
		String[] names = {"Kyaw Kyaw", "Maung Maung", "Ki Ki", "Cherry"};
		var list = new ArrayList<>(Arrays.asList(names));
		list.add("Aung Aung");
		//System.out.println(list);
		// a) all student names
		System.out.println("--- All student names ---");
		list.forEach(name -> System.out.println(name));
		
		// b) sort the list 
		System.out.println("\n--- The sorted list ---");
		Collections.sort(list);
		
		// c) the sorted list
		System.out.println(list);
		
		// d) Searching specified student and showing his position in the list
		System.out.println("\n--- Search 'Ki Ki' and Show his position ---");
		int result = Collections.binarySearch(list, "Ki Ki");
		System.out.println("'Ki Ki' has in list[" + result + "]");
		
		// e) inserting new student name
		System.out.println("\n--- Adding new student name ---");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter new name: ");
		String new_name = sc.nextLine();
		
		if(list.contains(new_name))
			System.err.println("This name has already included");
		else
			list.add(new_name);
		System.out.println(list);
		
		// f) show student who name start with 'k' or 'K'
		System.out.println("\n--- Student who name start with 'k' or 'K' ---");
		list.forEach(name -> {
			if(name.startsWith("k") || name.startsWith("K"))
				System.out.println(name);
		});
		
		// g) remove the student who name end with 'G' or 'g'
		System.out.println("\n--- After removing the student who name end with 'G' or 'g' ---");
		System.out.println("Before: " + list);
		list.removeIf(name -> name.endsWith("g") || name.endsWith("G"));
		System.out.println("After: " + list);
		
		// h) clear the list
		System.out.println("\n--- Clear list ---");
		list.clear();
		System.out.println("Is the list clear?: " + (list.isEmpty() ? "Yes" : "No"));
	}
}
