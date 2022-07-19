package day10.pkg3;

public class Teacher extends Person{
	
	private String position;
	
	public Teacher(String na, String pos) {
		super(na);
		this.position = pos;
	}

	@Override
	void showData() {
		super.showData();
		System.out.println("Position: " + this.position);
		System.out.println("------------------");
	}
	
	
}
