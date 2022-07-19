package day10.pkg3;

public class Demo {
	
	public static void main(String[] args) {
		Person p = new Person("Yuri");
		p.showData();
		
		Teacher t = new Teacher("James", "Professor");
		t.showData();
		
		Person p2 = new Teacher("Cherry", "Tutor");
		p2.showData();
	}
}
