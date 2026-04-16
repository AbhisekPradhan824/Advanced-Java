/**
 * Program to demonstrate JdbcRowSet..
 */

package jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JRSDemo {

	public static void main(String[] args) {
		try (JdbcRowSet jrs = new OracleJDBCRowSet()) {
			jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			jrs.setUsername("c##batch9am");
			jrs.setPassword("nareshit");
			jrs.setCommand("SELECT * FROM student");
			jrs.execute();
			
			ResultSetMetaData rmd = jrs.getMetaData();
			int count = rmd.getColumnCount();
			
			for(int i=1; i<=count; i++) {
				System.out.print(rmd.getColumnName(i)+"\t");
			}
			
			System.out.println("\n---------- -------------- ------------------");
			
			while(jrs.next()) {
				System.out.print(jrs.getInt(1)+"\t");
				System.out.print(jrs.getString(2)+"\t");
				System.out.println(jrs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
