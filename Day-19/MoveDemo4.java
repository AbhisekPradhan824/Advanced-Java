package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MoveDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##batch9am", "nareshit");
			System.out.println("Connected..");
			
			Statement st = con.createStatement();
			st.addBatch("INSERT INTO student VALUES (6, 'fff', 88)");
			st.addBatch("UPDATE student SET marks = 75 WHERE studentid = 3");
			st.addBatch("DELETE FROM student where studentid=5");
			st.executeBatch();
			System.out.println("Batch Operation Done....");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
