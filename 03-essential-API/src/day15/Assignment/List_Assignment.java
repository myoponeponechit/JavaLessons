package day15.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class List_Assignment {
	
	public static void main(String[] args) {
		
		var list = new ArrayList<Student>();
		
		// insert new student
		list.add(new Student("Aung Aung", 105));
		list.add(new Student("Cherry", 102));
		list.add(new Student("Hla Hla", 103));
		
		// sorting list
		Collections.sort(list, Student.StuRollno);
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
		System.out.println("\n------ Update student info: --------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter rno: ");
		int rno = Integer.parseInt(sc.nextLine());
		var stu_info = new Student(name, rno);
		list.set(0, stu_info);
		System.out.println("\n-------- After update ---------");
		System.out.println("Rno|\tName");
		System.out.println("---+--------------");
		list.forEach(stu -> {
			System.out.print(stu.rno);
			System.out.print("|\t" + stu.name);
			System.out.println();
		});
		
		// search with rno
		System.out.println("\n------- Search with rno --------");
		System.out.print("Enter roll no: ");
		int search_rno = Integer.parseInt(sc.nextLine());
		for(var obj : list) {
			if(obj.getRno() == search_rno) {
				System.out.println("Name: " + obj.getName());
				System.out.println("Rollno: " + obj.getRno());
			}
//			else {
//				System.err.println("This roll number does not exist!");
//				break;
//			}
		}
		
		//delete student info: specified according to roll
		System.out.println("\n------ Deleat specified roll number -----");
		System.out.print("Enter rno: ");
		int del_rno = sc.nextInt();
		for(var obj : list) {
			if(obj.getRno() == del_rno) {
				list.remove(obj);
				System.out.println("\n-------- After Delete ---------");
				System.out.println("Rno|\tName");
				System.out.println("---+--------------");
				list.forEach(stu -> {
					System.out.print(stu.rno);
					System.out.print("|\t" + stu.name);
					System.out.println();
				});
				//break;
			}
//			else {
//				System.err.println("This roll number does not exist!");
//				break;
//			}
		}
		}
	}


