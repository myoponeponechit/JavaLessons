package day15.Assignment;

import java.util.Comparator;

public class Student{
		
	    String name;
		int rno;
		
		public Student() {
			
		}
		public Student(String name, int rno) {
			super();
			this.name = name;
			this.rno = rno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getRno() {
			return rno;
		}
		public void setRno(int rno) {
			this.rno = rno;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", rno=" + rno + "]";
		}
		public static  Comparator<Student> StuRollno = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int rollno1 = o1.getRno();
				int rollno2 = o2.getRno();
				return rollno1-rollno2;
			}
			
		};
	}

	
