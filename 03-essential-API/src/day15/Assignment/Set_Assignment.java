package day15.Assignment;

import java.util.HashSet;
import java.util.Scanner;

public class Set_Assignment {
	
	public static void main(String[] args) {
		
		HashSet<Student>  stu_set = new HashSet<Student>();
		
		 stu_set.add(new Student("Aung Aung", 101));
		 stu_set.add(new Student("Cherry", 102));
		 stu_set.add(new Student("Hla Hla", 103));
		// sorting
		
		// display all student
		System.out.println("-------- All Students ---------");
		System.out.println("Rno\tName");
		System.out.println("---+--------------");
		for(var obj : stu_set) {
			System.out.print(obj.rno);
			System.out.print("|\t" + obj.name);
			System.out.println();
		}
		
		// update student information
				System.out.println("\n------ Update student info: --------");
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter name: ");
				String name = sc.nextLine();
				System.out.print("Enter rno: ");
				int rno = Integer.parseInt(sc.nextLine());
				var stu_info = new Student(name, rno);
				//stu_set.(0, stu_info);
				System.out.println("\n-------- After update ---------");
				System.out.println("Rno|\tName");
				System.out.println("---+--------------");
				stu_set.forEach(stu -> {
					System.out.print(stu.rno);
					System.out.print("|\t" + stu.name);
					System.out.println();
				});
				// search with rno
				System.out.println("\n------- Search with rno --------");
				System.out.print("Enter roll no: ");
				int search_rno = sc.nextInt();
				for(var obj : stu_set) {
					if(obj.getRno() == search_rno) {
						System.out.println("Name: " + obj.getName());
						System.out.println("Rno: " + obj.getRno());
						break;
					}
					else {
						System.err.println("This roll number does not exist!");
						break;
					}
				}
				//delete student info: specified according to roll
				System.out.println("\n------ Deleat specified roll number -----");
				System.out.print("Enter rno: ");
				int del_rno = sc.nextInt();
				for(var obj : stu_set) {
					if(obj.getRno() == del_rno) {
						stu_set.remove(obj);
						System.out.println("\n-------- After Delete ---------");
						System.out.println("Rno|\tName");
						System.out.println("---+--------------");
						stu_set.forEach(stu -> {
							System.out.print(stu.rno);
							System.out.print("|\t" + stu.name);
							System.out.println();
						});
						break;
					}
					else {
						System.err.println("This roll number does not exist!");
						break;
					}
				}
		System.out.println( stu_set);
	}
}

