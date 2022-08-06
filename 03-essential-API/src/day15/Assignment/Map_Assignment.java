package day15.Assignment;

import java.util.HashMap;
import java.util.Scanner;

public class Map_Assignment {
	
	public static void main(String[] args) {
		
		HashMap<Integer, Student> stu_map = new HashMap<>();
		
		stu_map.put(101, new Student("Aung Aung", 101));
		stu_map.put(102, new Student("Cherry", 102));
		stu_map.put(103, new Student("Hla Hla", 103));
		
		// insert new student
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Add new student info: ---");
		System.out.print("Enter rno: ");
		int rno = Integer.parseInt(sc.nextLine());
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		
		stu_map.put(rno, new Student(name, rno));
		// sorting
		
		// display all students
		System.out.println("\n--- All students ---");
		System.out.println("Rno|\tName");
		System.out.println("---+--------------");
		stu_map.forEach((k, v) -> {
			System.out.print(k);
			System.out.print("|\t" + v.name);
			System.out.println();
		});
		// update student information
		System.out.println("\n--- Update student info: ---");
		System.out.print("Enter rno: ");
		rno = Integer.parseInt(sc.nextLine());
		System.out.print("Enter name: ");
		name = sc.nextLine();
		
		stu_map.put(rno, new Student(name, rno));
		System.out.println("\n--- After Update ---");
		System.out.println("Rno|\tName");
		System.out.println("---+--------------");
		stu_map.forEach((k, v) -> {
			System.out.print(k);
			System.out.print("|\t" + v.name);
			System.out.println();
		});
		// search with roll number
		System.out.println("\n------- Search with rno --------");
		System.out.print("Enter roll no: ");
		int search_rno = sc.nextInt();
		stu_map.forEach((k, v) -> {
			if(k.equals(search_rno)) {
				System.out.println("Roll no: " + k);
				System.out.println("Name: " + v.name);
			}
			else {
				System.err.println("This roll number does not exist!");
			}
		});
		// delete student info: specified according to roll
	}
}
