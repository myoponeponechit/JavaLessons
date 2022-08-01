package day17.Assignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment2 {
	
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Htet Htet", "Yangon", "Electronics", 900000, LocalDate.of(1991,10,16)),
				new Employee("Cherry", "Yangon", "Electronics", 820000, LocalDate.of(1994, 8, 14)),
				new Employee("Kyaw Kyaw", "Yangon", "Electronics", 780000, LocalDate.of(1988, 9, 2)),
				new Employee("Aung Aung", "Mandalay", "IT", 600000, LocalDate.of(1995, 1, 11)),
				new Employee("Jeon", "Mandalay", "IT", 600000, LocalDate.of(1997, 9, 1)),
				new Employee("Hsu Hsu", "Pyin Oo Lwin", "IT", 920000, LocalDate.of(1994, 12, 10)),
				new Employee("Aye Aye", "Yangon", "HR", 500000, LocalDate.of(1992, 10, 10)),
				new Employee("Gay Gay", "Taung Gyi", "HR", 400000, LocalDate.of(1996, 5, 12)),
				new Employee("Phway Phway", "Monywa", "HR", 300000, LocalDate.of(1995, 9, 3)),
				new Employee("Ko Ko", "Monywa", "IT", 500000, LocalDate.of(1992, 11, 11))
				);
		// 1. Employee who get maximum salary
		int max_salary = empList.stream()
				.mapToInt(e -> e.getSalary())
				.max()
				.getAsInt();		
		System.out.println("1. Employee who get maximum salary: " + max_salary + " ks.");
		
		// 2. The youngest employee information
		
		// 3. Employee whose birthday is greater than or equal "1995-02-15" 
		
		// 4. Total salary of all employees
		Integer total = empList.stream()
				.collect(Collectors.summingInt(Employee::getSalary));
		System.out.println("\n4. Total salary of all employees: " + total + " ks.");
		
		// 5. the three max salary
		
		// 6. the average salary of department 'HR'
		Map<Object, Double> avg = empList.stream()
				.filter(e -> e.getDepartment().equals("HR"))
				.collect(
				Collectors.groupingBy(
						e -> e.getDepartment(),
						Collectors.averagingInt(Employee::getSalary))
						);
		System.out.println("\n6. The average salary of department 'HR': " + avg.values() + " ks.");
		
		// 7. Employee who get smallest salary
		
		
		// 8. highest salary of employee in each city
		
		
		// 9. employees who got the same salary
				Map<Integer, List<Employee>> sameSalary =  
									empList.stream()
									.collect(
											Collectors.collectingAndThen(
												Collectors.groupingBy(Employee::getSalary), // Map<String, List<Employee>>
													map -> map.entrySet() // (String, Set<Employee>)
													.stream()
													.filter(emp -> emp.getValue().size() > 1) // emp size > 1
													.collect(Collectors.toMap(val -> val.getKey(), val -> val.getValue()))
								)
						);
				System.out.println("\n--- 9. employees who got the same salary ---");
				sameSalary.forEach((key, value) -> {
					System.out.println(key + " ks.");
					value.forEach(emp -> {
						System.out.println("\t-> " + emp.getName() + "(" + emp.getDepartment() + ")");
					});
				});
		// 10. employees' name in each department
				Map<String, List<Employee>> eachDep = 
						empList.stream()
						.collect(
							Collectors.collectingAndThen(
									Collectors.groupingBy(Employee::getDepartment), // Map<String, List<Employee>>
									map -> map.entrySet() // (String, Set<Employee>)
									.stream()
									.filter(emp -> emp.getValue().size() > 1) // emp size > 1
									.collect(Collectors.toMap(val -> val.getKey(), val -> val.getValue()))
								)
						);
				System.out.println("\n-- 10. employees' name in each departmant --");
				eachDep.forEach((k, v) -> {
					System.out.println(k);
					v.forEach(e -> System.out.println("\t" + e.getName()));
				});
	}
}
