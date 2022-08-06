package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Connection_Testing {
	
	public static void main(String[] args) {
		
		//save_with_statement();
		//save_with_preparedStatement();
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter emp no: ");
			String no = sc.nextLine();
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			
			//find_with_statement(no, name);
			find_with_preparedStatement(no, name);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void find_with_preparedStatement(String no, String name) {
		try(  // create connection
				Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "")){
			//System.out.println("Get Connection....");
			// define query
			String query = "SELECT emp_no,city,birthday FROM employees WHERE emp_no = ?";
			
			// create statement
			PreparedStatement pstm = con.prepareStatement(query);
			// setXXX(index, value)
			pstm.setString(1, no);
			//pstm.setString(2, name);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				//System.out.println("Data exist");
				//System.out.println("No: " + rs.getString(1));
				System.out.println("No: " + rs.getString("emp_no"));
				//System.out.println("City: " + rs.getString(2));
				System.out.println("City: " + rs.getString("city"));
				//System.out.println("Dob: " + rs.getDate(3));
				System.out.println("Dob: " + rs.getDate("birthday"));
			}
			else {
				System.out.println("There is no data");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void save_with_preparedStatement() {
		try(  // create connection
				Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "")){
			System.out.println("Get Connection....");

			// define query
			String query = "INSERT INTO employees(emp_no, name, salary, city, birthday)VALUES(1004, 'Cherry', 1200000, 'Yangon','1990-3-22')";
			
			// create prepared statement
			PreparedStatement pstm = con.prepareStatement(query);
			
			// execute query 
			//   1. select => executeQuery()( return result set )
			//   2. transaction(insert/update/delete) => executeUpdate()( return number of affected row )
			
			pstm.executeUpdate();
			System.out.println("Insert success...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void find_with_statement(String no, String name) {
		try(  // create connection
				Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "")){
			//System.out.println("Get Connection....");
			
			// create statement
			Statement st = con.createStatement();
			
			// define query
			String query = "SELECT city,birthday FROM employees WHERE emp_no = " + no;
			
			// execute query 
			//   1. select => executeQuery()( return result set )
			//   2. transaction(insert/update/delete) => executeUpdate()( return number of affected row )
			
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				System.out.println("Data exist");
			}
			else {
				System.out.println("There is no data");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void save_with_statement() {
		try(  // create connection
				Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "")){
			System.out.println("Get Connection....");
			
			// create statement
			Statement st = con.createStatement();
			
			// define query
			String query = "INSERT INTO employees(emp_no, name, salary, city, birthday)VALUES(1003, 'Kyaw Kyaw', 500000, 'Mandalay','1997-8-12')";
			
			// execute query 
			//   1. select => executeQuery()( return result set )
			//   2. transaction(insert/update/delete) => executeUpdate()( return number of affected row )
			
			st.executeUpdate(query);
			System.out.println("Insert success...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
