package LEVEL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementClass {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		Statement st = con.createStatement();
		String str = "insert into users values(2,'mahi','rahul',0)";
		
		int i = st.executeUpdate(str);
		System.out.println("No of rows inserted....."+i);
		
		String sql = "select * from users";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(4));
		}
		st.close();
		rs.close(); //is not needed because it's a leightweight process
		con.close(); //but..con,st should all be closed since it has heavy objects
		
	}
}
