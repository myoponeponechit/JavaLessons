package day8;

public class EmployeeDemo {
	
	public static void main(String[] args) {
		try {
			// create object
			Employee emp1 = new Employee();
			Employee emp2 = new Employee();
			Employee emp3 = new Employee();
			
			// initialize data
			emp1.initData("Jone", 1000000);
			emp2.initData("Yuri", 700000);
			emp3.initData("PCY", 2500000);
			
			// show data
			System.out.println("ID\tName\tSalary");
			System.out.println("-------------------------");
			emp1.showData();
			emp2.showData();
			emp3.showData();
			
			Employee.changeNoOfEmployee(10);
			// create 4th employee object
			var emp4 = new Employee(); // occur exception
			emp4.initData("James", 650000);
			emp4.showData();
			
			emp4.viewInformation();
		} catch (AppException e) {
			System.err.println(e.getMessage());
		}
	}
}
