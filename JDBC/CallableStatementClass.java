package LEVEL1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementClass {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		CallableStatement cs = con.prepareCall("{call proc1(?,?)}");
		
		cs.setInt(1, 3);
		cs.registerOutParameter(2, Types.VARCHAR);
		
		cs.execute();
		System.out.println("The usname of 3 is....."+cs.getString(2));
		
		con.close(); //but..con,st should all be closed since it has heavy objects
	}
}
