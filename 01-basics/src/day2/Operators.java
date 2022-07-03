package day2;

public class Operators {
	
	public static void main(String[] args) {
		int num1 = 100, num2 = 200;
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		
		System.out.println(num1 + " > " + num2 + " = " + (num1 > num2));
		
		System.out.println("80 is divisible with both 5 and 3 : " + (80%5 == 0 && 80%4 == 0));
		
		String result = (num1%2 == 0) ? "even" : "odd";
		System.out.println(num1 + " is " + result);
		
		num1 += 50; // num1 = num1 + 50 = 100 + 50 = 150
		System.out.println("After change,num1 : " + num1);
	}

}
