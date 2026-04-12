/**
 * Program to demonstrate PreparedStatement with java.sql.Date class...
 */

package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am","nareshit");
			System.out.println("Connected...");
			PreparedStatement ps = con.prepareStatement("INSERT INTO emp VALUES (?,?,?)");
			ps.setInt(1, Integer.parseInt(args[0]));
			ps.setString(2, args[1]);
			ps.setDate(3, Date.valueOf(args[2]));
			ps.executeUpdate();
			System.out.println("Record inserted...");
		} catch (NumberFormatException |ClassNotFoundException | SQLException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
