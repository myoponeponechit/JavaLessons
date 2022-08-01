package day19;

public class Employee {
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	public static Employee getEmployeeFromLine(String line) {
		String[] data = line.split("\t");
		Employee emp = new Employee();
		emp.setId(Integer.parseInt(data[0]));
		emp.setName(data[1]);
		emp.setCity(data[2]);
		return emp;
	}
}
