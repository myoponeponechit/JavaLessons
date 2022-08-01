package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMap_Testing {
	
	public static void main(String[] args) {
		
		List<String> drinks = Arrays.asList("Cola", "Milk Tea", "Pessi");
		List<String> foods = List.of("Burgar", "Kyay Oho", "Noodles", "Cake");
		List<String> desserts = List.of("Icecream", "Cake");
		
		List<List<String>> items = new ArrayList<>();
		
		items.add(drinks);
		items.add(foods);
		items.add(desserts);
		
		for(var item : items) {
			System.out.println(item);
		}
		
		Set<String> flatSet = items.stream()
				.flatMap(data -> data.stream())
				.collect(Collectors.toSet());
		System.out.println("After flatMap: " + flatSet);
	}
}
