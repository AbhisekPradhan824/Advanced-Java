/**
 * Program to demonstrate CallableStatement with output Parameter...
 */
package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class SelectDemo5 {

	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am","nareshit");
			System.out.println("Connected..");
			
			CallableStatement cs= con.prepareCall("call getmarks(?,?)");
			System.out.println("Enter the Student Roll number: ");
			cs.setInt(1, scn.nextInt());
			
			cs.registerOutParameter(2, Types.INTEGER);
			
			cs.execute();
			
			int marks = cs.getInt(2);
			
			System.out.println(marks);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		scn.close();

	}

}
