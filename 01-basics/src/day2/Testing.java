package day2;

public class Testing {
	
	int num;// instance var/field
	static int price; // static var/field or non-instance var
	//var price = 1000;
	void display() {
		int bar_code;// local variable
		var name = "Aung Aung";
		var rno = 1;
		//System.out.println("Barcode : " + bar_code);
		int a = 20, b = 30;
		//var c = 20, d = 40;//can't use
	}
	public static void main(String[] args) {
		//System.out.println("Hello");
		
		// call static var (direct call with class name)
		Testing.price = 10; 
		
		// call instance var (need to create object)
		Testing obj = new Testing(); 
		obj.num = 10;
		
		obj.num = 30;
	}
}
