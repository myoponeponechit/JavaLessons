package day10;

public class K extends A{
	int b;
	public K() {
		System.out.println("K's default constructor");
	}
	
	public K(int j) {
		super(j); // without super(one arg) => it calls A's default constructor
		System.out.println("K's argument constructor");
	}
}
