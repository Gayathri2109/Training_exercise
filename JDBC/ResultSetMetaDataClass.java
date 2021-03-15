package LEVEL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataClass {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		Statement st = con.createStatement();
		
		
		String sql = "select * from users";
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		
		System.out.println("No. of Cols =" +rsmd.getColumnCount());
		
//		for(int i=1;i<=rsmd.getColumnCount();i++)
//		{
//		String c=rsmd.getColumnName(i);
//		String c1=rsmd.getColumnTypeName(i);
//		String c2=rsmd.getColumnLabel(i);
//		System.out.println("columne name " +c +" type name "+c1+" label " +c2);
//		}
		
	st.close();
	rs.close(); //is not needed because it's a leightweight process
	con.close(); //but..con,st should all be closed since it has heavy objects
		
		
	}
	
}
