package day12;

public interface InterfaceTesting {
	
	void abstractMethod();
	
	default void defaultMethod() {
		System.out.println("This is default method.");
	}
	
	static void staticMethod() {
		System.out.println("This is static method.Can't override.");
	}
	
	private void privateMethod() {
		System.out.println("This is private method.");
	}
}

class MyClass implements InterfaceTesting{

	@Override
	public void abstractMethod() {
		System.out.println("This is abstract method.");
		
	}
	
//	@Override
//	public void defaultMethod() {
//		System.out.println("This is overrided default method.");
//	}
	
}
