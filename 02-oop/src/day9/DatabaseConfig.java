package day9;

public class DatabaseConfig {
	// 2 static field
	private static DatabaseConfig config;
	
	// 1 private constructor
	private DatabaseConfig() {
		
	}
	
	// 3 static method
	static DatabaseConfig getInstance() {
		if(config == null)
			config = new DatabaseConfig();
		
		return config;
		
	}
}
