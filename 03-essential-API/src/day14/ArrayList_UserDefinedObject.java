package day14;

import java.util.ArrayList;

public class ArrayList_UserDefinedObject {
	public static void main(String[] args) {
		var list = new ArrayList<Phone>();
		
		Phone obj = new Phone("Vivo", 500000);
		
		list.add(obj);
		list.add(new Phone("iPhone", 2000000));
		list.add(new Phone("Samsung", 1500000));
		
		list.forEach(p -> {
			System.out.println("Brand: " + p.name);
			System.out.println("Price: " + p.price);
			System.out.println("--------------");
		});
		
		System.out.println("--- Price > 500000 ---");
		list.forEach(p -> {
			if(p.price > 500000)
				System.out.println(p.name + "(price: " + p.price + " ks.)");
		});
		System.out.println("---------------------------");
		Phone res = list.get(0);
		System.out.println("Name: " + res.name + "\nPrice: " + res.price);
	}
}

class Phone {
	String name;
	int price;
	public Phone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
}
