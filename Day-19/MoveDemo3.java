package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoveDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##batch9am", "nareshit");
			System.out.println("Connected..");
			
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs =st.executeQuery("SELECT studentid, studentname, marks FROM student");
			
			rs.moveToInsertRow();
			
			rs.updateInt(1, 6);
			rs.updateString(2, "fff");
			rs.updateInt(3, 59);
			rs.insertRow();
			System.out.println("one record inserted..");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
