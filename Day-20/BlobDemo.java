/**
 * Program to demonstrate Blob...
 */

package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobDemo {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##batch9am", "nareshit");
			System.out.println("Connected");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO images VALUES (?,?)");
			ps.setString(1, args[0]);
			FileInputStream fis=new FileInputStream(args[1]);
			ps.setBinaryStream(2, fis, fis.available());
			ps.executeUpdate();
			System.out.println("One Record inserted..");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
