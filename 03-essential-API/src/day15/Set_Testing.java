package day15;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_Testing {
	
	public static void main(String[] args) {
		
		//test_HashSet();
		//test_LinkedHashSet();
		test_TreeSet();
	}

	private static void test_TreeSet() {
		var set1 = new TreeSet<String>();
		set1.add("Orange");
		set1.add("Apple");
		//set1.add(null); TreeSet can't access null value
		set1.add("Orange");
		set1.add("Mango");
		set1.add("Strawberry");
		
		System.out.println(set1);
		
	}

	private static void test_LinkedHashSet() {
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Orange");
		set1.add("Mango");
		set1.add("Strawberry");
		
		System.out.println(set1);
		//set1.removeIf(obj -> obj.toLowerCase().contains("o")); // this expression don't access null value
		set1.removeIf(str -> str != null && str.toLowerCase().contains("o"));
		System.out.println("After remove, " + set1);
		
	}

	private static void test_HashSet() {
		HashSet<String> set1 = new HashSet<>();
		
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Orange");
		set1.add("Mango");
		set1.add("Strawberry");
		
		System.out.println(set1);
		
		set1.remove("Apple");
		System.out.println("After remove, " + set1);
		
		var set2 = Set.of("Potato", "PipeApple");
		
		// add collection
		
		set1.addAll(set2);
		System.out.println("After addall, " + set1);
	}
}
