package day14;

import java.util.Stack;

public class Stack_Testing {
	
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		
		stack.add("Yangon");
		stack.push("Mandalay");
		stack.push("Pyin Oo Lwin");
		stack.push("Monywa");
		
		System.out.println(stack); // just output
		
		String tmp = stack.pop();
		System.out.println(tmp);
		System.out.println("After pop: " + stack);
		
	}
}
