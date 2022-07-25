package day14;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Testing {

	public static void main(String[] args) {
		
		// create empty arraylist
		ArrayList<Integer> list = new ArrayList<>();
		// var list = new ArrayList<>();
		
		// add an element
		list.add(100);
		list.add(50);
		list.add(20);
		list.add(10);
		System.out.println("Number of item: " + list.size());
		System.out.println(list);
		
		// add with specific index
		list.add(1, 520);
		System.out.println(list);
		System.out.println("After add, list[2]: " + list.get(2));
		
		// display all items with for each
		list.forEach(num -> System.out.println(num));
		
		// update element
		list.set(0, 23);
		System.out.println("After update 23 to list[0]: \n" + list);
		
		System.out.println("List is empty?: " + list.isEmpty());
		
		// remove element by index
		list.remove(1);
		System.out.println("After remove list[1]:\n" + list);
		
		// maximum & manimum
		System.out.println("Maximum: " + Collections.max(list));
		System.out.println("Minimum: " + Collections.min(list));
		
		// remove all elements
		list.clear();
		System.out.println("List is empty?: " + list.isEmpty());
		System.out.println("Size of list: " + list.size());
	}
}
