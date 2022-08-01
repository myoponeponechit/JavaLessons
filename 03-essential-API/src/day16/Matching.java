package day16;

import java.util.List;

public class Matching {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(2,4,6,8,10,11);
		
		boolean allEven = numbers.stream()
				.allMatch(num -> num%2 == 0);
		System.out.println("All even: " + allEven);
		
		boolean oneEven = numbers.stream()
				.anyMatch(num -> num%2 == 0);
		System.out.println("One even: " + oneEven);
		
		boolean noneEven = numbers.stream()
				.noneMatch(num -> num%2 == 0);
		System.out.println("None even: " + noneEven);
	}
}
