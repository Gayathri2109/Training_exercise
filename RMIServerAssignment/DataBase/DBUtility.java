package DataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {

private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("dbproperties.properties"));
			Class.forName(prop.getProperty("driver"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> tlocal = new ThreadLocal<Connection>();
	
	synchronized public static Connection getConnection()
	{
		Connection con = tlocal.get();
		if(con==null)
		{
			try {
				con = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
				con.setAutoCommit(false);
				tlocal.set(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return con;
	}
	
	synchronized public static void closeConnection(Exception e) {
		Connection con = tlocal.get();
		try {
		if(con!=null)
		{
			if(e==null) {
				con.commit();
				
			}else {
				con.rollback();
				con.commit();
			}
			tlocal.remove();
			con.close();
			
		}}catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
