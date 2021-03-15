package LEVEL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class ProgramaticTransacManagement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		con.setAutoCommit(false);
		
		Savepoint sp = null;
		try {
		Statement st = con.createStatement();
		st.executeUpdate("update users set flag=1 where uid=1");
		sp = con.setSavepoint("first");
		st.executeUpdate("update users set flag=1 where uuid=1");
		con.commit();
		}catch(Exception e)
		{
			con.rollback(sp);
			con.commit();
		}
		
		
	}
}
