/**
 * Program to Demonstrate CallableStatement..1
 */

package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am","nareshit");
			System.out.println("Connected..");
			
			CallableStatement cs= con.prepareCall("call insertPro(?,?,?)");
			cs.setInt(1, Integer.parseInt(args[0]));
			cs.setString(2, args[1]);
			
			cs.setInt(3, Integer.parseInt(args[2]));
			cs.execute();
			
			System.out.println("Inserted..");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

}
