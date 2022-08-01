package day16;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {
	
	public static void main(String[] args) {
		
		List<User> users = List.of(
				new User("Kyaw Kyaw", "admin"),
				new User("Aung Aung", "staff"),
				new User("Maung Maung", "staff"),
				new User("Yuki", "customer"),
				new User("Jeon", "customer")
				);
//		users.stream()
//			//.filter(u -> u.getRole().equals("staff"))
//			.filter(User::IsStaff)
//			.forEach(u -> {
//				System.out.println("Name: " + u.getName());
//				System.out.println("Role: " + u.getRole());
//			});
		
//		List<String> names = users.stream()
//								.filter(u -> u.getName().contains("aung") && u.getRole().equals("staff"))
//								.map(u -> u.getName())
//								.collect(Collectors.toList());
//		System.out.println(names);
		
		Stream<Integer> numbers = Stream.iterate(1, i -> (i + 1))
				.limit(15);
		
		Predicate<Integer> evens = i -> i%2 == 0;
		numbers.filter(n -> (n > 4 && n <= 10))
		.filter(evens)
		.forEach(System.out::println);
	}
}
