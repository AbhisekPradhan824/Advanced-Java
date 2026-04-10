package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##batch9am", "nareshit");
			System.out.println("Connected to database successfully..");
			
			Statement st =conn.createStatement();
			boolean res = st.execute("Create table student (studentid Number(3), studentName varchar2(30), marks number(3))");
			if(!res) {
				System.out.println("Table Created");
			}else {
				System.out.println("There is a problem occured..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
