/**
 * Program to demonstrate CallableStatement with function
 */
package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am", "nareshit");
			System.out.println("Connected");
			CallableStatement cs = conn.prepareCall("{?= call totalstudents}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			int total = cs.getInt(1);
			System.out.println(total);
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}

	}

}
