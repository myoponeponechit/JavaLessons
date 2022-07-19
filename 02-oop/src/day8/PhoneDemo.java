package day8;

public class PhoneDemo {

	public static void main(String[] args) {
		// creating object
		Phone phone1 = new Phone("Samsung", "white", 700000);
		Phone phone2 = new Phone("Vivo", "pink", 450000);
		Phone phone3 = new Phone("iPhone", "black", 2500000);
		
		System.out.println("------- Phone 1's Info --------\n");
		System.out.println("Brand: " + phone1.brand);
		System.out.println("Color: " + phone1.color);
		System.out.println("Price: " + phone1.price);
		
		phone1.call();
		phone1.sendSmss();
		
		System.out.println("\n------- Phone 2's Info --------\n");
		System.out.println("Brand: " + phone2.brand);
		System.out.println("Color: " + phone2.color);
		System.out.println("Price: " + phone2.price);
		
		phone2.call();
		phone2.sendSmss();
		
		System.out.println("\n------- Phone 3's Info --------\n");
		System.out.println("Brand: " + phone3.brand);
		System.out.println("Color: " + phone3.color);
		System.out.println("Price: " + phone3.price);
		
		phone3.call();
		phone3.sendSmss();
		
		// call static field
		//phone1.shop = "ABC";
		
		// other way with class name
		Phone.shop = "ABC";
		System.out.println("\nPhone 2's shop name: " + phone2.shop);
	}
}
