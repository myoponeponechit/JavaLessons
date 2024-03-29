package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Creating_List {
	
	public static void main(String[] args) {
		// create immutable empty list
		List<String> list1 = List.of();
		//list1.add("Aung Aung");
		
		// create immutable data list
		List<String> list2 = List.of("Aung Aung", "Mg Mg", "Hla Hla");
		//list2.add("Khing");
		
		// create mutable empty list
		List<String> list3 = new ArrayList<String>();
		System.out.println("Number of element: " + list3.size());
		list3.add("Aung Aung");
		list3.add("Khing");
		System.out.println("Number of element: " + list3.size());
		
		Integer[] numbers = {100, 200, 300, 400};
		
		List<Integer> list4 = new ArrayList<>(Arrays.asList(numbers));
		System.out.println("Number of element in list4: " + list4.size());
	}
}
