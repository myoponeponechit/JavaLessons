package day15;

import java.util.HashMap;
import java.util.Map;

public class Map_Testing {
	public static void main(String[] args) {
		
		test_hashMap();
	}

	private static void test_hashMap() {
		var foods = new HashMap<String,String>();
		
		foods.put("Orange", "Fruit");
		foods.put("Grape", "Fruit");
		
		var another1 = Map.of("Mango", "Fruit", "Potato", "Vegetable");
		foods.putAll(another1);
		System.out.println(foods);
		
		var another2 = Map.ofEntries(
				Map.entry("Coffee", "Juice"),
				Map.entry("Lemon Tea", "Juice")
				);
		foods.putAll(another2);
		foods.forEach((k,v)-> {
			System.out.println(k + " -> " + v);
			
		});
		
		foods.putIfAbsent("Kiwi", "Fruit");
		System.out.println("After new element, " + foods);
		
		System.out.println("Contains 'coffee': " + foods.containsKey("Coffee"));
		System.out.println("Contains 'icecream': " + foods.containsValue("Icecream"));
		
		var keys = foods.keySet();
		System.out.println("All keys: " + keys);
		
		var value = foods.values();
		System.out.println("All value: " + value);
		
		System.out.println("Specified element: " + foods.get("Coffee"));
		System.out.println("Specified element: " + foods.get("abc"));
		
//		// remove
//		foods.remove("Mangon");
//		System.out.println("After remove, " + foods);
//		
//		foods.keySet().removeIf(k -> k.contains("Tea"));
//		System.out.println("After remove, " + foods);
		
		// update
		foods.replace("Mango", "Juice");
		System.out.println("value of mango: " + foods.get("Mango"));
		
		foods.compute("Coffee", (k,v) -> v.toUpperCase());
		System.out.println("value of coffee: " + foods.get("Coffee"));
		
		foods.compute("Cake", (k,v) -> "Snack");
		System.out.println(foods);
		
		foods.computeIfAbsent("Orange", k -> "Juice");
		System.out.println("value of 'Orange': " + foods.get("Orange"));
		
		foods.computeIfAbsent("Banana", k -> "Fruit");
		System.out.println(foods);
		
		foods.computeIfPresent("Orange", (k,v) -> "Juice");
		System.out.println("value of 'Orange': " + foods.get("Orange"));
		
		foods.computeIfPresent("Corn", (k,v) -> "Vegetable");
		System.out.println("value of 'Corn': " + foods.get("Corn"));
		
	}	
}
