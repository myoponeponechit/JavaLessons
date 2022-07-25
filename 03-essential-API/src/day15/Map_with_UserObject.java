package day15;

import java.util.HashMap;
import java.util.Map;

public class Map_with_UserObject {
	public static void main(String[] args) {
		//Map<Integer, Employee> employees = new HashMap<>();
		var employees = new HashMap<Integer, Employee>();
		
		Employee emp = new Employee(1001, "Aung Aung", "Yangon");
		
		employees.put(1001,emp);
		employees.put(1002, new Employee(1002, "Cherry", "Pyin Oo Lwin"));
		employees.put(1003, new Employee(1003, "Naung Naung", "Yangon"));
		
		System.out.println(employees);
		
		// for each
		employees.forEach((k, obj) -> {
			System.out.println("Id: " + obj.getId());
			System.out.println("Name: " + obj.getName());
			System.out.println("City: " + obj.getCity());
			System.out.println("------------------------");
		});
		
		
		Employee obj = employees.get(1001);
		System.out.println("Obj: " + obj);
		
		System.out.println("\n--- Employees in Yangon ---");
		employees.forEach((k, val) -> {
			if(val.getCity().toLowerCase().equals("yangon"))
				System.out.println(val.getName());
		});
	}
	
}

class Employee {
	
	private int id;
	private String name;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Employee(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	
}