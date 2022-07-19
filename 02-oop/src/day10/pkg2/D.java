package day10.pkg2;

import day10.pkg1.A;

public class D {
	
	void test() {
		var obj = new A();
		//obj.number = 300; // error (different package)
		//obj.name = "Cherry"; // error (different package)
		obj.age = 22; // ok because it is public
	}
}
