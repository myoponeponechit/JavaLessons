package day15.Assignment;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Set_Assignment {
	
	static HashSet<Student>  stu_set = new HashSet<Student>();
	public static void main(String[] args) {
		
		 try(Scanner sc = new Scanner(System.in)) {
			 stu_set.add(new Student("Aung Aung", 101));
			 stu_set.add(new Student("Cherry", 102));
			 stu_set.add(new Student("Aye Aye", 103));
			// sorting
			 List<Student> studentList = stu_set.stream().sorted((e1, e2) -> 
			 e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
			 //System.out.println(studentList);
			 
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
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					System.out.print("Enter rno: ");
					int rno = Integer.parseInt(sc.nextLine());
					
					stu_set.add(new Student(name, rno));
					
					showData(stu_set);
					// search with rno
					System.out.println("\n------- Search with rno --------");
					System.out.print("Enter roll no: ");
					int search_rno = Integer.parseInt(sc.nextLine());
					search(search_rno);

					//delete student info: specified according to roll
					System.out.println("\n------ Deleat specified roll number -----");
					System.out.print("Enter rno: ");
					int del_rno = sc.nextInt();
					delete(del_rno);
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
				
				
	}

	private static void showData(HashSet<Student> stu_set2) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("\n-------- After update ---------");
			System.out.println("Rno|\tName");
			System.out.println("---+--------------");
			stu_set.forEach(stu -> {
				System.out.print(stu.rno);
				System.out.print("|\t" + stu.name);
				System.out.println();
			});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void search(int search_rno) {
		try(Scanner sc = new Scanner(System.in)) {
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
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void delete(int del_rno) {
		try(Scanner sc = new Scanner(System.in)) {
			for(var obj : stu_set) {
				if(obj.getRno() == del_rno) {
					stu_set.remove(obj);
					showData(stu_set);
					break;
				}
				else {
					System.err.println("This roll number does not exist!");
					break;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

