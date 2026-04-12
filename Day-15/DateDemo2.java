
/**
 * JDBC Code to change date Format...
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am","nareshit");
			System.out.println("Connected..");
			
			PreparedStatement ps= con.prepareStatement("INSERT INTO emp VALUES (?,?,?)");
			ps.setInt(1, Integer.parseInt(args[0]));
			ps.setString(2, args[1]);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date d1=sdf.parse(args[2]); 
			java.sql.Date dd= new java.sql.Date(d1.getTime());
			
			ps.setDate(3, dd);
			ps.executeUpdate();
			
			System.out.println("Inserted..");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
