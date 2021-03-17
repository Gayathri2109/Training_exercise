package DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CustomerMasterDAOimpl implements CustomerMasterDAO {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	private ResultSetMetaData rsmd; 
	Set<CustomerMasterDTO> set;
	CustomerMasterDTO custMasterDTO;
	
	public CustomerMasterDAOimpl(Connection con) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/bill","root","gayu");
		this.con = con;
		st = con.createStatement();
	}
	
	@Override
	public int insertCustomer(CustomerMasterDTO custMasterDTO) {
		int ItemsInserted = 0;
		
		try {
			ps = con.prepareStatement("insert into customers values(?,?,?,?,?)");
			ps.setInt(1,custMasterDTO.getCustNo());
			ps.setString(2, custMasterDTO.getCustName());
			ps.setString(3, custMasterDTO.getCustAddress());
			ps.setString(4, custMasterDTO.getCustEmail());
			ps.setString(5, custMasterDTO.getCustPhone());
			ItemsInserted = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return ItemsInserted;
		
	}
	
	@Override
	public int updateCustomer(CustomerMasterDTO custMasterDTO) {
		int CustUpdated = 0;
		Scanner s = new Scanner(System.in);
		try {
			ps = con.prepareStatement("update customers set custPhone=? where custNo=?");
		
			//This case is to update the phone no of the customer - for eg....
			System.out.println("Enter the new phone no and ur cust ID....");
			String val = s.next();
			ps.setString(1,val);
			int custId = s.nextInt();
			ps.setInt(2, custId);
			CustUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return CustUpdated;
	}
	

	@Override
	public int deleteCustomer(int custNo) {
		int Deleted  = 0;
		try {
			ps = con.prepareStatement("delete from customers where custNo=?");
			ps.setInt(1, custNo);
			Deleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return Deleted;
	}
	
	
	@Override
	public CustomerMasterDTO getCustomerMaster(int custNo) {
		try {
			ps = con.prepareStatement("select * from customers where custNo=?");
			ps.setInt(1, custNo);
			rs = ps.executeQuery();
			
			custMasterDTO = new CustomerMasterDTO();
			
			while(rs.next()) {
				custMasterDTO.setCustNo(rs.getInt(1));
				custMasterDTO.setCustName(rs.getString(2));
				custMasterDTO.setCustAddress(rs.getString(3));
				custMasterDTO.setCustEmail(rs.getString(4));
				custMasterDTO.setCustPhone(rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(custMasterDTO);
		return custMasterDTO;
	}
	
	
	@Override
	public Set<CustomerMasterDTO> getCustomerMasterAll() {
	
		set = new HashSet<CustomerMasterDTO>();
	
		
		try {
			rs = st.executeQuery("SELECT COUNT(*) AS rowcount FROM customers");
			rs.next();
			int count = rs.getInt("rowcount") ;
			rs.close() ;
			System.out.println("MyTable has " + count + " row(s).");
			
			for(int i=1;i<=count;i++) {
			
				custMasterDTO = getCustomerMaster(i);
				set.add(custMasterDTO);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	
}
