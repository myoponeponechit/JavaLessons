package day10;

public class Student extends Person{
	private int rno;
	
	// rno = 1, name = "Cherry", phone = "9592567809"
	public Student(int rno, String name, String phone) {
		super(name, phone); // name = "Cherry", phone = "9592567809"
		this.rno = rno; // rno = 1
	}
	
	public int getRno() {
		return rno;
	}
	
	public void setRno(int rno) {
		this.rno = rno;
	}
}
