package day15.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class List_Assignment {
	
	public static void main(String[] args) {
		
		var list = new ArrayList<Student>();
		
		// insert new student
		list.add(new Student("Aung Aung", 101));
		list.add(new Student("Cherry", 102));
		list.add(new Student("Hla Hla", 103));
		
		// sorting list
		
		// display all student
		System.out.println("-------- All Students ---------");
		System.out.println("Rno\tName");
		System.out.println("---+--------------");
		list.forEach(stu -> {
			System.out.print(stu.rno);
			System.out.print("|\t" + stu.name);
			System.out.println();
		});
		
		// update student information
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter rno: ");
		int rno = Integer.parseInt(sc.nextLine());
		var stu_info = new Student(name, rno);
		list.set(0, stu_info);
		System.out.println("\n-------- After update ---------");
		System.out.println("Rno\tName");
		System.out.println("---+--------------");
		list.forEach(stu -> {
			System.out.print(stu.rno);
			System.out.print("|\t" + stu.name);
			System.out.println();
		});
		
		// search with rno
	}
}

class Student {
	
    String name;
	int rno;
	
	public Student(String name, int rno) {
		super();
		this.name = name;
		this.rno = rno;
	}

}
