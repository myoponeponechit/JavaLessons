package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_Search_Sort {
	
	public static void main(String[] args) {
		String[] data = {"Aung Aung", "Jeon", "Yuki", "Maung Maung"};
		var list = new ArrayList<>(Arrays.asList(data));
		
		list.add("Jeon");
		System.out.println(list);
		
		// sort asc
		Collections.sort(list);
		System.out.println("After sorting, list: " + list);
		
		// sort desc
		Collections.reverse(list);
		System.out.println("After reverce sorting, list: " + list);
		
		// binary search(return index)
		int result = Collections.binarySearch(list, "Jeon");
		System.out.println("Has 'Jeon' in list?: " + (result < 0 ? "Not found" : "Found"));
		
		result = Collections.binarySearch(list, "Hla Hla");
		System.out.println("Has 'Hla Hla' in list?: " + (result < 0 ? "Not found" : "Found"));
		
		// search with contain(return boolean)
		System.out.println("--- Search 'Aung Aung' ---");
		if(list.contains("Aung Aung"))
			System.out.println("Found");
		else
			System.out.println("Not found");
		
		// remove by value
		list.remove("Jeon");
		System.out.println("After remove: " + list);
		
		// remove by lambda expression
		list.removeIf(name -> name.endsWith("ung") && name.length() > 9);
		System.out.println("After remove by lambda expression: " + list);
	}
}
