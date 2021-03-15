package LEVEL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EnumerationClass {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		Enumeration e = DriverManager.getDrivers();
		System.out.println(" "+DriverManager.getLoginTimeout());
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
		
		con.close(); //but..con,st should all be closed since it has heavy objects
	}
}
