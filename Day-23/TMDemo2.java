/**
 * Program to demonstrate savePoint ...
 */

package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TMDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","**********","***********");
			Statement st = con.createStatement();
			con.setAutoCommit(false);
			st.executeUpdate("Insert into student values (9,'iii' ,89)");
			Savepoint sp =con.setSavepoint();
			st.executeUpdate("Insert into student values (10,'jjj' ,24)");
			con.rollback(sp);
			st.executeUpdate("DELETE FROM student where studentid=4");
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
