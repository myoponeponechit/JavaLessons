package day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import day16.Employee;

public class Grouping {
	
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuki", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
				);
		// number of employee in each city
		Map<String, Long> counting = empList.stream()
									.collect(Collectors.groupingBy(
											e -> e.getCity(),
											Collectors.counting())
									);
		System.out.println(counting);
		
		// total salary in each city
		Map<String, Integer> total = empList.stream()
									.collect(Collectors.groupingBy(
											e -> e.getCity(),
											Collectors.summingInt(Employee::getSalary))
										);
		System.out.println(total);
		
		// average salary of each city
		Map<String, Double> avg = empList.stream()
								.collect(
								Collectors.groupingBy(
										e -> e.getCity(),
										Collectors.averagingDouble(Employee::getSalary))
										);
		System.out.println(avg);
		System.out.println("-------------------------------------------");
		
		// employees who got the same salary
		Map<Integer, List<Employee>> sameSalary = empList.stream()
													.collect(Collectors.groupingBy(
															Employee::getSalary)
														);
		sameSalary.forEach((key, value) -> {
			System.out.println(key + " ks.");
			value.forEach(emp -> {
				System.out.println("\t" + emp.getName() + "(" + emp.getCity() + ")");
			});
		});
		
		// employees' name in each city
		Map<String, List<String>> names = empList.stream()
											.collect(
													Collectors.groupingBy(Employee::getCity, // key
															Collectors.mapping(Employee::getName, // map emp object to string 
																	Collectors.toList() // convert to List
																)
														)
											);
		System.out.println("\n-- Employees' name who stay same city --");
		names.forEach((key, value) -> {
			System.out.println(key);
			value.forEach(name -> {
				System.out.println("\t" + name);
			});
		});
		
		// employees who stay in same city
		Map<String, List<Employee>> sameCity = 
				empList.stream()
				.collect(
					Collectors.collectingAndThen(
							Collectors.groupingBy(Employee::getCity), // Map<String, List<Employee>>
							map -> map.entrySet() // (String, Set<Employee>)
							.stream()
							.filter(emp -> emp.getValue().size() > 1) // emp size > 1
							.collect(Collectors.toMap(val -> val.getKey(), val -> val.getValue()))
						)
				);
		System.out.println("\n-- employees who stay in same city --");
		sameCity.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(e -> System.out.println("\t" + e.getName()));
		});
	}
}
