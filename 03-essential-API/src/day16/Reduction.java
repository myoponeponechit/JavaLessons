package day16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Reduction {
	
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuki", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
				);
		
		int total = empList.stream()
					.mapToInt(e -> e.getSalary())
					.sum();
		
		double average = empList.stream()
					.mapToDouble(e -> e.getSalary())
					.average()
					.getAsDouble();
		
		int max_salary = empList.stream()
					.mapToInt(e -> e.getSalary())
					.max()
					.getAsInt();
		
		long count = empList.stream()
					.filter(e -> e.getSalary() > 6000)
					.count();
		
		Employee max_emp = empList.stream() // output -> object
					.max(Comparator.comparingInt(e -> e.getSalary()))
					.get();
		
		Employee min_emp = empList.stream() // output -> object
					.min((e1, e2) -> e1.getSalary() - e2.getSalary())
					.get();
		
		System.out.println("Total: " + total);
		System.out.println("Average: " + average);
		System.out.println("Maximum: " + max_salary);
		System.out.println("Employee who get salary above 6000: " + count);
		System.out.println("-- Employee who get maximum salary --\n" + max_emp); 
		System.out.println("\n-- Employee who get minimum salary --\n" + min_emp);
		
		System.out.println("\n--- Custom reduction(reduce()) ---");
		total = empList.stream()
				.map(Employee::getSalary )
				.reduce(0, (s1, s2) -> s1 + s2);
		
		int min_sal = empList.stream()
				.mapToInt(e -> e.getSalary())
				.reduce(Integer::min)
				.getAsInt();
		
		Employee max_employee = empList.stream()
				.reduce((e1,  e2) -> e1.getSalary() < e2.getSalary() ? e2 : e1)
				.get();
		System.out.println("Total: " + total);
		System.out.println("Minimum salary: " + min_sal);
		System.out.println("-- Max employee --\n" + max_employee);
	}
}
