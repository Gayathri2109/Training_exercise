package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ItemTransactionDAOimpl  implements ItemTransactionDAO {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	private ResultSetMetaData rsmd; 
	Set<ItemTransactionDTO> set;
	ItemTransactionDTO itemTransactionDTO;
	
	public ItemTransactionDAOimpl(Connection con) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/bill","root","gayu");
		this.con = con;
		st = con.createStatement();	}
	
	@Override
	public int insertItem(ItemTransactionDTO itemTransactionDTO) {
		int ItemInserted = 0;
		
		try {
			ps = con.prepareStatement("insert into Transaction values(?,?,?)");
			ps.setInt(1, itemTransactionDTO.getInvNo());
			ps.setInt(2, itemTransactionDTO.getItemNo());
			ps.setInt(3, itemTransactionDTO.getQty());
			
			ItemInserted = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return ItemInserted;
	}
	
	@Override
	public int updateItem(ItemTransactionDTO itemTransactionDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteItem(int itemNo) {
		int itemDeleted  = 0;
		try {
			ps = con.prepareStatement("delete from Transaction where itemNo=?");
			ps.setInt(1, itemNo);
			itemDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return itemDeleted;
	}
	
	@Override
	public ItemTransactionDTO getItemMaster(int invNo) {
		
		try {
			ps = con.prepareStatement("select * from Transaction where invNo=?");
			ps.setInt(1, invNo);
			rs = ps.executeQuery();
			
			itemTransactionDTO= new ItemTransactionDTO();
		
			while(rs.next()) {
				itemTransactionDTO.setInvNo(rs.getInt(1));
				itemTransactionDTO.setItemNo(rs.getInt(2));
			    itemTransactionDTO.setQty(rs.getInt(3));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(invMasterDTO);
		return itemTransactionDTO;
	}
	
	@Override
	public Set<ItemTransactionDTO> getItemMasterAll() {
		set = new HashSet<ItemTransactionDTO>();
		try {
			rs = st.executeQuery("SELECT COUNT(*) AS rowcount FROM Transaction");
			rs.next();
			int count = rs.getInt("rowcount") ;
			rs.close() ;
			System.out.println("MyTable has " + count + " row(s).");
			
			for(int i=1;i<=count;i++) {
				itemTransactionDTO = getItemMaster(i);
				//System.out.println(invMasterDTO);
				set.add(itemTransactionDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

//	public static void main(String[] args) throws Exception {
//		ItemTransactionDAOimpl im = new ItemTransactionDAOimpl(DBUtility.getConnection());
//		Set<ItemTransactionDTO> set;
//		set = im.getItemMasterAll();
//		System.out.println(set);
//	}
}

