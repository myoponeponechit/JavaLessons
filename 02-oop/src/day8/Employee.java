package day8;

public class Employee {
	static int noOfEmployee = 3; // static field
	static int nextId = 1; // static field
	final int empId; // final field
	String name; // instance field
	int salary; // instance field
	
	static final float BONUS = 2.5f; // const var
	
	public Employee() throws AppException {
		if(nextId > noOfEmployee)
			throw new AppException("Sorry! Limited number have been reached.");
		empId = nextId;
		nextId++;
	}
	
	public void initData(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void changeData(String new_name, int new_salary) {
		if(!name.equalsIgnoreCase(new_name))
			this.name = new_name;
		if(this.salary != new_salary)
			this.salary = new_salary;
	}
	public void showData() {
		System.out.println(this.empId + "\t" + this.name + "\t" + this.salary + " ks");
	}
	
	// static method
	public static void changeNoOfEmployee(int no) {
		noOfEmployee = no; // ok
		//this.name = "Ki Ki"; // can't use 'this' keyword
		//salary = 1000000; // can't access instance variable
		//showData(); // can't invoke instance method
	}
	
	// instance method
	public void viewInformation() {
		System.out.println("Total employee: " + noOfEmployee); // can access static
		System.out.println("----- Current employee info -----");
		this.showData(); // instance method
		System.out.println("Next employee's ID: " + nextId); // static field
	}
}

// static method can only access static value
// instance method can access both static and instance value