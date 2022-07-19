package day11;

import java.util.Arrays;

public class Compile_time_poly {
	
	public static void main(String[] args) {
		System.out.println("100 + 200 = " + Addition.add(100, 200));
		System.out.println("int array's sum: " + Addition.add(new int[] {100,200,300}));
		System.out.println("35.4 + 23.9 = " + Addition.add(35.4f, 23.9f));
		System.out.println("'Hello' + 'World!' = " + Addition.add("Hello", "World!"));
	}
}

class Addition {
	static int add(int a, int b) {
		return (a + b);
	}
	
	static int add(int[] numbers) {
		return Arrays.stream(numbers).sum();
	}
	
	static float add(float a, float b) {
		return (a + b);
	}
	
	static String add(String a, String b) {
		return (a + b);
	}
}
