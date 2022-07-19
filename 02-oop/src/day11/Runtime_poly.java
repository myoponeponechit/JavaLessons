package day11;

public class Runtime_poly {
	
	public static void main(String[] args) {
		Developer dev = new Developer();
		dev.work();
		
		dev = new FrontendDeveloper();
		dev.work();
		
		dev = new BackendDeveloper();
		dev.work();
	}
}

class Developer {
	void work() {
		System.out.println("Some work!");
	}
}

class FrontendDeveloper extends Developer{
	@Override
	void work() {
		System.out.println("Work with frontend technologies!");
	}
}

class BackendDeveloper extends Developer{
	@Override
	void work() {
		System.out.println("Work with backend technologies!");
	}
}