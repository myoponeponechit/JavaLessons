package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionsManagement {
	
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_3", "root", "");
			
			var insert1 = "INSERT INTO students(id,email, name)VALUE(?, ?, ?)";
			var insert2 = "INSERT INTO students(id,email, name)VALUE(?, ?, ?)";
			var update = "UPDATE students SET email = ? WHERE id = ?";
			
			// disable auto-commit mode
			con.setAutoCommit(false);
			
			var pstm = con.prepareStatement(insert1);
			pstm.setInt(1, 1);
			pstm.setString(2, "jeon@gmail.com");
			pstm.setString(3, "Jeon");
			pstm.executeUpdate();
			
			pstm = con.prepareStatement(insert2);
			pstm.setInt(1, 2);
			pstm.setString(2, "cherry@gmail.com");
			pstm.setString(3, "Cherry");
			pstm.executeUpdate();
			
			pstm = con.prepareStatement(update);
			pstm.setString(1, "cherry@gmail.com");
			pstm.setInt(2, 1);
			pstm.executeUpdate();
			
			con.commit(); // all data commit
			System.out.println("Success");
		}
		catch (Exception e) {
			con.rollback(); // roll back all changes
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
