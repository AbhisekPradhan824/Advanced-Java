package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##batch9am", "nareshit");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *FROM student");
			ResultSetMetaData rmd =rs.getMetaData();
			int count = rmd.getColumnCount();
			
			for(int i=1; i<=count; i++) {
				System.out.print(rmd.getColumnName(i)+ "\t");
			}
			System.out.println();
			while(rs.next()) {
					System.out.print(rs.getInt("studentid") + "\t");
					System.out.print(rs.getString("Studentname")+ "\t");
				System.out.println(rs.getInt("marks"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
