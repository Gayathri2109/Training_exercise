package LEVEL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class DatabaseClass {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		DatabaseMetaData dbmd=(DatabaseMetaData) con.getMetaData();
		System.out.println("DatabaseProductName :"+dbmd.getDatabaseProductName());
		System.out.println("DatabaseProductVersion:"+dbmd.getDatabaseProductVersion());
		System.out.println("getStringFunctions :"+dbmd.getStringFunctions());
		System.out.println("DriverMajorVersion :"+dbmd.getDriverMajorVersion());
		System.out.println("DriverMinorVersion :"+dbmd.getDriverMinorVersion ());
		System.out.println("DriverName : "+dbmd.getDriverName ());
	    System.out.println("SQLKeywords : "+dbmd.getSQLKeywords());
	    con.close();
	}


	
}
