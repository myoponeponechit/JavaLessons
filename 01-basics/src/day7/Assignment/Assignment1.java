package day7.Assignment;

public class Assignment1 {
	public static void main(String[] args) {
		try {
			String[] num_arr = {"1000", "230", "450"}; //, "ac", "?", "59", "45.8"
			MyClass num_arr1 = new MyClass(num_arr);
			int total = 0;
			for(var item : num_arr) {
				int item_int = Integer.parseInt(item);
				total += item_int;
				System.out.println(item_int);
			}
			int average = total / num_arr.length; // num_arr.length
			System.out.println("Average: " + average);
			
			var i = 0;
			if(i < num_arr.length) {
				int max = Integer.parseInt(num_arr[i]);
				int sec = Integer.parseInt(num_arr[i+1]);
				int third = Integer.parseInt(num_arr[i+2]);
				if(max < sec) {
					max = sec;
					if(max > third) {
						System.out.println("Maximum: " + sec);
					}
					else {
						System.out.println("Maximum: " + third);
					}
				}
				else if(max < third) {
					max = third;
				}
			}
			
			var result = num_arr[9].isEmpty();
			
		}
		catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		
	}
}

class MyClass {
	String[] numbers ;
	public MyClass() {
		
	}
	public MyClass(String[] num_arr) {
		this.numbers = num_arr;
	}
}