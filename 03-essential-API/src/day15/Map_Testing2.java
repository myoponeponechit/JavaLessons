package day15;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Map_Testing2 {
	
	public static void main(String[] args) {
		//test_LinkHashMap();
		test_TreeMap();
	}

	private static void test_TreeMap() {
		var file_extensions = new TreeMap<String, String>();
		file_extensions.put("java", ".java");
		file_extensions.put("html", ".html");
		file_extensions.put("javascript", ".js");
		file_extensions.put("php", ".php");
		file_extensions.put("cplusplus", ".cpp");
		
		System.out.println(file_extensions);
		
		file_extensions.remove("java");
		
		System.out.println("val of java: " + file_extensions.get("java"));
	}

	private static void test_LinkHashMap() {
		
		var students = new LinkedHashMap<Integer, String>();
		
		students.put(11, "Aung Aung");
		students.put(5, "Kyaw Kyaw");
		students.put(8, "Honey");
		
		students.putIfAbsent(10, "Cherry");
		System.out.println(students);
		
		students.replace(8, "Honey Htun");
		
		System.out.println("value of 8: " + students.get(8));
		
		students.remove(11);
		System.out.println("After remove, " + students);
	}
}
