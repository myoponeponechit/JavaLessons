package day17.Assignment;

import java.time.LocalDate;

public class Employee {
	
	private String name;
	private String city;
	private String department;
	private int salary;
	private LocalDate Birthday;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDate getBirthday() {
		return Birthday;
	}
	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}
	public Employee(String name, String city, String department, int salary, LocalDate birthday) {
		super();
		this.name = name;
		this.city = city;
		this.department = department;
		this.salary = salary;
		Birthday = birthday;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", department=" + department + ", salary=" + salary
				+ ", Birthday=" + Birthday + "]\n";
	}
	
	
}
