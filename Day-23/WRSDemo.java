/**
 * Program to demonstrate WebRowSet ....
 */

package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WRSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			WebRowSet wrs = new OracleWebRowSet();
			wrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			wrs.setUsername("********");
			wrs.setPassword("*******");
			wrs.setCommand("SELECT * FROM student");
			wrs.execute();
			
			FileOutputStream fos =new FileOutputStream("student.xml");
			wrs.writeXml(fos);
			wrs.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
