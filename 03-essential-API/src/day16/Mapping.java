package day16;

import java.util.Arrays;
import java.util.List;

public class Mapping {
	
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuki", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
				);
		
		List<String> distinctCities = empList.stream()
				.map(c -> c.getCity())
				.distinct()
				.toList();
				
	System.out.println(distinctCities);
	
	int[] salaries = empList.stream()
			.filter(e -> e.getSalary() > 6000)
			.mapToInt(s -> s.getSalary())
			.toArray();
	System.out.println(Arrays.toString(salaries));
	
	List<Integer> salaryList = empList.stream()
			.map(emp -> emp.getSalary()) // object -> integer
			.filter(sal -> sal < 10000) // sal is integer
			.limit(3)
			.toList();
	System.out.println(salaryList);
	
	int max_salary = empList.stream()
			.mapToInt(e -> e.getSalary())
			.max()
			.getAsInt();
	System.out.println("Maximum salary: " + max_salary);
	
	int min_salary = empList.stream()
			.mapToInt(emp -> emp.getSalary())
			.min()
			.getAsInt();
	System.out.println("Minimum salary: " + min_salary);
	}
}
