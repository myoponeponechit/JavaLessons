package day13;

import java.util.List;

public class Lambda_ExpressionWithCollection {
	
	public static void main(String[] args) {
		List<String> language = List.of("HTML", "CSS", "Javascript", "Java", "PHP");
		
		language.forEach(lang -> System.out.println(lang)); // Lambda Expression for each loop
		
//		for(String lang : language) {  // simple for each loop
//			System.out.println(lang);
//		}
		
		System.out.println("--- Contain 'Java' ---");
		language.forEach(lang -> {
			if(lang.contains("Java"))
				System.out.println(lang);
		});
	}
}
