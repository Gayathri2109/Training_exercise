package LEVEL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetClass {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		Statement st = con.createStatement();
		
		
		String sql = "select * from users";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
			
		{
			System.out.print(rs.getInt(1));
			System.out.print(" "+rs.getString(2));
			System.out.print(" "+rs.getString(3));
			System.out.print(" "+rs.getInt(4)+"\n");
		}
		
		st.close();
		rs.close(); //is not needed because it's a leightweight process
		con.close(); //but..con,st should all be closed since it has heavy objects
	}
}
