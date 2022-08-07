package day22;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class Testing_2 {

		public static void main(String[] args) {
			
			//saveMultipleObject();
			//updateData();
			//deleteData();
			//showData();
			showSpecifieData();
		}

		private static void showSpecifieData() {
			try(var sc = new Scanner(System.in)) {
				var con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "");
				
				//var query = "SELECT * FROM employees WHERE salary BETWEEN ? AND ?"; // retrieve 1
				var query = "SELECT * FROM employees WHERE emp_no IN(?,?,?)"; // retrieve 2
				
				PreparedStatement pstm = con.prepareStatement(query);
				
				// retrieve 1
				pstm.setDouble(1, 600000);
				pstm.setDouble(2, 1000000);
				
				// retrieve 2
				pstm.setInt(1, 1001);
				pstm.setInt(2, 1008);
				pstm.setInt(3, 1005);
				
				ResultSet rs = pstm.executeQuery();
				System.out.println("Emp_no\tName\tSalary");
				System.out.println("-------------------------");
				while(rs.next()) {
					System.out.print(rs.getInt("emp_no") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getDouble("salary") + "\n");
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static void showData() {
			try(var sc = new Scanner(System.in)) {
				var con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "");
				
				var query = "SELECT * FROM employees";
				
				PreparedStatement pstm = con.prepareStatement(query);
				
				ResultSet rs = pstm.executeQuery();
				System.out.println("Emp_no\tName\tSalary\tCity\tDOB");
				System.out.println("------------------------------------");
				while(rs.next()) {
					System.out.print(rs.getInt("emp_no") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getDouble("salary") + "\t");
					System.out.print(rs.getString("city") + "\t");
					System.out.print(rs.getDate("birthday") + "\n");
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static void deleteData() {
			try(var sc = new Scanner(System.in)) {
				var con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "");
				
				var query = "DELETE FROM employees WHERE name LIKE ?";
				
				PreparedStatement pstm = con.prepareStatement(query);
				
				System.out.print("Enter city: ");
				pstm.setString(1, "%" + sc.nextLine() + "%");
				
				System.out.println("Number of affected row: " + pstm.executeUpdate());
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static void updateData() {
			try(var sc = new Scanner(System.in)) {
				var con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "");
				
				var query = "UPDATE employees SET salary = (salary + salary * 0.2) WHERE city = ?";
				
				PreparedStatement pstm = con.prepareStatement(query);
				
				System.out.print("Enter city: ");
				pstm.setString(1, sc.nextLine());
				
				System.out.println("Number of affected row: " + pstm.executeUpdate());
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static void saveMultipleObject() {
			try(var sc = new Scanner(System.in)) {
				var con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "");
				
				var query = "INSERT INTO employees(emp_no, name, salary, birthday, city)VALUES(?,?,?,?,?)";
				
				var pstm = con.prepareStatement(query);
				
				for(var i = 0; i < 2; i++) {
					System.out.print("Enter emp no: ");
					pstm.setInt(1, Integer.parseInt(sc.nextLine()));
					
					System.out.print("Enter name: ");
					pstm.setString(2, sc.nextLine());

					System.out.print("Enter salary: ");
					pstm.setDouble(3, Double.parseDouble(sc.nextLine()));
					
					System.out.print("Enter date of birth: ");
					pstm.setDate(4, Date.valueOf(sc.nextLine()));
					
					System.out.print("Enter city: ");
					pstm.setString(5, sc.nextLine());
					
					pstm.addBatch();
					System.out.print("Employee " + (i + 1) + " is saved.\n");
					
				}
				pstm.executeBatch();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
}
