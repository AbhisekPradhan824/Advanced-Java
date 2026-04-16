/**
 * Program to demonstrate setAutoCommit(), commit() and rollback() methods ...
 */

package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TMDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","*******","******");
			Statement st = con.createStatement();
			con.setAutoCommit(false);
			st.executeUpdate("Insert into student values (8,'hhh' ,92)");
			con.commit();
			st.executeUpdate("Insert into student values (9,'iii' ,24)");
			con.rollback();
			st.executeUpdate("DELETE FROM student where studentid=5");
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
