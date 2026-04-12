package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am","nareshit");
		System.out.println("Connected to database..");
		PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, Integer.parseInt(args[0]));
		ps.setString(2, args[1]);
		ps.setInt(3, Integer.parseInt(args[2]));
		ps.executeUpdate();
		System.out.println("Record inserted Successfully..");
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
