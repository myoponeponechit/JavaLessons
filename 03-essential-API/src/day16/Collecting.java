package day16;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Collecting {
	
	public static void main(String[] args) {
		
		Student[] students = {
				new Student(10, "cherry", "yangon"),
				new Student(2, "cherry", "mandalay"),
				new Student(5, "khing", "monywa"),
				new Student(1, "htet", "mandalay"),
				new Student(11, "htet yadana", "yangon")
		};
		
		Set<String> hashSet = Arrays.stream(students)
							.map(Student::getName)
							.collect(Collectors.toSet());
		System.out.println("Hashset: " + hashSet);
		
		TreeSet<Integer> treeSet = Arrays.stream(students)
							.map(s -> s.getRno())
							.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Treeset: " + treeSet);
		
		Map<Integer, String> map_1 = Arrays.stream(students)
							.collect(Collectors.toMap(
									Student::getRno, // key
									Student::getName)); // value
		System.out.println("Map1: " + map_1);
		
		Map<Integer, Student> map_2 = Arrays.stream(students)
							.filter(s -> !s.getCity().equals("yangon"))
							.collect(Collectors.toMap(
									Student::getRno, // key
									s -> s)); // value
		System.out.println("Map2: " + map_2);
	}
}
