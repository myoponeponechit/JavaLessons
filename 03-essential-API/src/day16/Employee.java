package day16;

public class Employee {
	
	private String name;
	private int salary;
	private String city;
	
	public Employee() {
		
	}

	public Employee(String name, int salary, String city) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nSalary: " + salary + "\nCity: " + city;
	}
	
}
