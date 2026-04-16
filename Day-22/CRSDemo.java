/**
 * Program to demonstrate CachedRowSet..
 */

package jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;


public class CRSDemo {

	public static void main(String[] args) {
		try {
			CachedRowSet crs = new OracleCachedRowSet(); 
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs.setUsername("c##batch9am");
			crs.setPassword("nareshit");
			crs.setCommand("SELECT * FROM student");
			crs.execute();
			
			ResultSetMetaData rmd = crs.getMetaData();
			int count = rmd.getColumnCount();
			
			for(int i=1; i<=count; i++) {
				System.out.print(rmd.getColumnName(i)+"\t");
			}
			
			System.out.println("\n---------- -------------- ------------------");
			
			while(crs.next()) {
				System.out.print(crs.getInt(1)+"\t");
				System.out.print(crs.getString(2)+"\t");
				System.out.println(crs.getInt(3));
			}
			crs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
