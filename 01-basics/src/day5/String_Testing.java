package day5;

public class String_Testing {

		public static void main(String[] args) {
			String s1 = new String(new char[] {'M', 'P', 'P', 'C'});
			String s2 = new String("Java Programming");
			String s3 = "Myanmar IT Consulting";
			
			System.out.println("s1's length: " + s1.length());
			System.out.println("s2's length: " + s2.length());
			
			// change
			System.out.println("s3's uppercase: " + s3.toUpperCase());
			System.out.println("After change, s3: " + s3);
			
			// substring
			var substr = s2.substring(0, 4); // start, end-1
			System.out.println("Substring : " + substr);
			System.out.println("After substring, s2: " + s2);
			System.out.println("substring2: " + s2.substring(8));
			
			// replace
			System.out.println("Replace: " + s2.replace("Java", "Spring"));
			System.out.println("After replace, s2: " + s2);
			
			// concat
			System.out.println("Concat: " + s2.concat(" Language"));
			System.out.println("After concat, s2: " + s2);
			
			// finding
			System.out.println("s2 contains 'Java': " + s2.contains("Java"));
			System.out.println("s2 start with 'PHP': " + s2.startsWith("PHP"));
			
		}
}
