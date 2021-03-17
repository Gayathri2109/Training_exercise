package DataBase;

import java.sql.Array;
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

public class ItemMasterDAOimpl implements ItemMasterDAO {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	private ResultSetMetaData rsmd; 
	Set<ItemMasterDTO> set;
	ItemMasterDTO itemMasterDTO;
	
	public ItemMasterDAOimpl(Connection con) throws Exception {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/bill","root","gayu");
		this.con = con;
		st = con.createStatement();
	}

	@Override
	public int insertItem(ItemMasterDTO itemMasterDTO) {
		int ItemsInserted = 0;
		
		try {
			ps = con.prepareStatement("insert into items values(?,?,?,?)");
			ps.setInt(1,itemMasterDTO.getItemNo());
			System.out.println("haiiiii");
			ps.setString(2, itemMasterDTO.getItemName());
			ps.setInt(3, itemMasterDTO.getItemPrice());
			ps.setInt(4, itemMasterDTO.getItemQuantity());
			ItemsInserted = ps.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return ItemsInserted;
		
	}
	
	@Override
	public int updateItem(ItemMasterDTO itemMasterDTO) {
		int ItemsUpdated = 0;
		Scanner s = new Scanner(System.in);
		try {
			ps = con.prepareStatement("update items set itemPrice=? where itemNo=?");
		
			//This case is to update the price of the item - for eg....
			System.out.println("Enter the new price and the item no....");
			int val = s.nextInt();
			ps.setInt(1,val);
			int no = s.nextInt();
			ps.setInt(2, no);
			ItemsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return ItemsUpdated;
		
	}
	
	@Override
	public int deleteItem(int itemNo) {
		int ItemsDeleted  = 0;
		try {
			ps = con.prepareStatement("delete from items where itemNo=?");
			ps.setInt(1, itemNo);
			ItemsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return ItemsDeleted;
		
	}
	
	@Override
	public ItemMasterDTO getItemMaster(int itemNo) {
		
		try {
			ps = con.prepareStatement("select * from items where itemNo=?");
			ps.setInt(1, itemNo);
			rs = ps.executeQuery();
			
			itemMasterDTO = new ItemMasterDTO();
			
			while(rs.next()) {
				itemMasterDTO.setItemNo(rs.getInt(1));
				itemMasterDTO.setItemName(rs.getString(2));
				itemMasterDTO.setItemPrice(rs.getInt(3));
				itemMasterDTO.setItemQuantity(rs.getInt(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemMasterDTO;
	}
		
		
	
	@Override
	public Set<ItemMasterDTO> getItemMasterAll() {
	
		set = new HashSet<ItemMasterDTO>();
		
		try {
			rs = st.executeQuery("SELECT COUNT(*) AS rowcount FROM items");
			rs.next();
			int count = rs.getInt("rowcount") ;
			rs.close() ;
			System.out.println("MyTable has " + count + " row(s).");
			
			for(int i=1;i<=count;i++) {
	
				itemMasterDTO = getItemMaster(i);	
				set.add(itemMasterDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;	
	}

}
