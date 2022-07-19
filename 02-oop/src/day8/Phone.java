package day8;

public class Phone {
	// fields
	String brand;
	String color;
	int price;
	
	// static field
	static String shop;
	
	// constructors
	public Phone(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	// methods
	public void call() {
		System.out.println("Phone calling can be made here.");
	}
	
	public  void  sendSmss() {
		System.out.println("Message can be sent at here.");
	}
	
}
