package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch9am","nareshit");
			System.out.println("Connected to Database..");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE studentid=?");
			System.out.println("Enter Student Roll No");
			ps.setInt(1, scn.nextInt());
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rmd = rs.getMetaData();
			int length=rmd.getColumnCount();
			for(int i=1; i<=length; i++) {
				System.out.print(rmd.getColumnName(i)+" ");
			}
			System.out.println();
			rs.next();
				for(int i=1; i<=length; i++) {
					System.out.print(rs.getString(i)+"\t");
				} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    scn.close();
	}

}
