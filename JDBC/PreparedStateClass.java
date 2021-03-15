package LEVEL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStateClass {

public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ey","root","gayu");
		
		System.out.println(con);
		
		//PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)");
		//? values can be got dynamically........
		
//		ps.setInt(1, 5);
//		ps.setInt(4, 0);
//		
//		ps.setString(2, "gayu");
//		ps.setString(3, "Venkat");
//		
//		int i = ps.executeUpdate();
//		System.out.println(i);
		

		PreparedStatement ps=con.prepareStatement("select * from users where uid=?");
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("Please enter a uid...:");
			int uid=Integer.parseInt(scan.next());
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
					System.out.println(uid+"..:"+rs.getString("uname"));
			}
		
		}
		
		
	}
}
