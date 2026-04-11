package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am", "nareshit");
			System.out.println("Connected to Database Successfully..");
			Statement st= con.createStatement();
			st.executeUpdate("INSERT INTO student values (111, 'aaa', 70)");
			System.out.println("Record inserted successfully..");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
