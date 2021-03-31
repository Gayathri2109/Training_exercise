package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import service.ShoppingService;
import service.ShoppingServiceImpl;

public class ItemMasterDAOimpl implements ItemMasterDAO {
	
	private static ItemMasterDAOimpl itemmasterdaoimpl;
	private Properties prop;
	public ItemMasterDAOimpl(Properties prop) {
		this.prop=prop;
	}
	

	synchronized public static ItemMasterDAOimpl getItemDAOImpl(Properties prop) {

		if(itemmasterdaoimpl==null) {
			itemmasterdaoimpl=new ItemMasterDAOimpl(prop);
			return itemmasterdaoimpl;
		}
		else {
			return itemmasterdaoimpl.createClone();
		}
	}
	
	
	public ItemMasterDAOimpl createClone() {
		try {
			return (ItemMasterDAOimpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}

	/*@Override
	public int insertItem(ItemMasterDTO itemMasterDTO) {
		int ItemsInserted = 0;
		
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement("insert into items values(?,?,?,?)");
			
			ps.setInt(1, itemMasterDTO.getShopId());
			ps.setInt(2,itemMasterDTO.getItemNo());
			ps.setString(3, itemMasterDTO.getItemName());
			ps.setInt(4, itemMasterDTO.getItemPrice());
		
			ItemsInserted = ps.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return ItemsInserted;
		
	}*/
	
	@Override
	public int updateItem(ItemMasterDTO itemMasterDTO) {
		int ItemsUpdated = 0;
		Scanner s = new Scanner(System.in);
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement("update items set itemPrice=? where itemNo=?");
		
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
	public int deleteItem(int itemNo){
		int ItemsDeleted  = 0;
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement("delete from items where itemNo=?");
			ps.setInt(1, itemNo);
			ItemsDeleted = ps.executeUpdate();
			//ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return ItemsDeleted;
		
	}
	
	/*
	@Override
	public ItemMasterDTO getItemMaster(int itemNo) {
		
		
		try {
			ItemMasterDTO itemMasterDTO = new ItemMasterDTO();
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement("select * from items where itemNo=?");
			ps.setInt(1, itemNo);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				itemMasterDTO.setShopId(rs.getInt(1));
				itemMasterDTO.setItemNo(rs.getInt(2));
				itemMasterDTO.setItemName(rs.getString(3));
				itemMasterDTO.setItemPrice(rs.getInt(4));
				//System.out.println(itemMasterDTO);
			}
			//System.out.println(itemMasterDTO);
			DBUtility.closeConnection(null);
			return itemMasterDTO;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
		
		
	
	@Override
	public Set<ItemMasterDTO> getItemMasterAll(int shopId) {
	
		Set<ItemMasterDTO> set = new HashSet<ItemMasterDTO>();
		Connection con=DBUtility.getConnection(prop);
		
		
		try {
			ItemMasterDTO itemMasterDTO = new ItemMasterDTO();
			Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS rowcount FROM items where shopId=?");
			ps.setInt(1, shopId);
			
			ResultSet rs = ps.executeQuery();
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

	@Override
	public Set<Integer> getItemNos(int shopId) {
		Set<Integer> set = new HashSet<Integer>();
		
		
		try {
			ItemMasterDTO itemMasterDTO = new ItemMasterDTO();
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement("select itemNo from items where shopId=?");
			ps.setInt(1, shopId);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) {
				//itemMasterDTO.setShopId(rs.getInt(1));
				itemMasterDTO.setItemNo(rs.getInt(1));
				//itemMasterDTO.setItemName(rs.getString(3));
				//itemMasterDTO.setItemPrice(rs.getInt(4));
				
				set.add(itemMasterDTO.getItemNo());


			}


			return set;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return set;
	}
	
	@Override
	public Set<ItemMasterDTO> getItems(int shopId) {
		Set<ItemMasterDTO> set = new HashSet<ItemMasterDTO>();
		
		try {
			ItemMasterDTO itemMasterDTO = new ItemMasterDTO();
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement("select * from items where shopId=?");
			ps.setInt(1, shopId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				itemMasterDTO.setShopId(rs.getInt(1));
				itemMasterDTO.setItemNo(rs.getInt(2));
				itemMasterDTO.setItemName(rs.getString(3));
				itemMasterDTO.setItemPrice(rs.getInt(4));
				set.add(itemMasterDTO);
				
			}
			System.out.println(set);
			return set;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return set;
	}
	
	@Override
	public Set<String> getNames(int shopId) {
		Set<String> set = new HashSet<String>();
		
		try {
			
			Set<Integer> setInt = itemmasterdaoimpl.getItemNos(shopId);
			Iterator<Integer> ite = setInt.iterator();
			
			while (ite.hasNext()) {
		         int i  = ite.next();
		         ItemMasterDTO item =  itemmasterdaoimpl.getItemMaster(i);
		         set.add( item.getItemName());
			 }
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return set;
	}
	
	
	@Override
	public Set<ItemMasterDTO> getAll(int shopId)
	{	
		ItemMasterDAO it = new ItemMasterDAOimpl(prop);
		Set<Integer> set = it.getItemNos(shopId);
		Iterator<Integer> ite = set.iterator();
		Set<ItemMasterDTO> dto = new HashSet<ItemMasterDTO>();
		while(ite.hasNext())
		{
			dto.add(it.getItemMaster(ite.next()));
		}
		
		return dto;
		
	}
	
	
	public static void main(String[] args) throws Exception, IOException {
		ItemMasterDTO item = new ItemMasterDTO();
//		item.setShopId(3);
//		item.setItemNo(4);
//		item.setItemName("Orange");
//		item.setItemPrice(40);
		Properties prop = new Properties();
		prop.load(new FileInputStream("dbconfig.properties"));
		ItemMasterDAO it = ItemMasterDAOimpl.getUserDAOImpl(prop);
		
		Set<Integer> setint = it.getItemNos(3);
		System.out.println(setint);
		Iterator<Integer> ite = setint.iterator();
		Set<ItemMasterDTO> set = new HashSet<ItemMasterDTO>();
		while(ite.hasNext()) {
			ItemMasterDTO dto = it.getItemMaster(ite.next());
			set.add(dto);
			
		}
		
		System.out.println(set);
		
		
		
		
//		//System.out.println(it.getAll(1));

//		Set<Set<ItemMasterDTO>> dto = new HashSet<Set<ItemMasterDTO>>();
//		Set<ItemMasterDTO> dto1 = new HashSet<ItemMasterDTO>();
//		int count = 0;
//		while(ite.hasNext()) {
//			//System.out.println(it.getAll(ite.next()));
//			dto1 = it.getAll(ite.next());
//			dto.add(dto1);
//			count++;
//			
//			
//		}
//		System.out.println("No of rows:"+count);
//		
		
		
        
}*/


	@Override
	public ItemMasterDTO getItem(int item_no) {
		try {
			ItemMasterDTO itemDTO = new ItemMasterDTO();
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("select * from items where itemNo=?");
			ps.setInt(1, item_no);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				itemDTO.setItem_category(rs.getInt(1));
				itemDTO.setItem_no(rs.getInt(2));
				itemDTO.setItem_name(rs.getString(3));
				//itemDTO.setItem_unit(rs.getInt(3));
				itemDTO.setItem_price(rs.getInt(4));
			}
			
			DBUtility.closeConnection(null);
			return itemDTO;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}


	@Override
	public Set<ItemMasterDTO> getAllItem() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<ItemMasterDTO> getAllItemOfCategory(int category) {
		try {
			ItemMasterDTO itemDTO;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","gayu");
			//Connection con = DBUtility.getConnection(prop);
			System.out.println(con);
			Set<ItemMasterDTO> itemset =  new HashSet<ItemMasterDTO>() ;
			PreparedStatement ps=con.prepareStatement("select * from items where shopId=?");
			ps.setInt(1, category);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				itemDTO= new ItemMasterDTO();
				itemDTO.setItem_category(rs.getInt(1));
				itemDTO.setItem_no(rs.getInt(2));
				itemDTO.setItem_name(rs.getString(3));
				//itemDTO.setItem_unit(rs.getInt(4));
				itemDTO.setItem_price(rs.getInt(4));
				
				itemset.add(itemDTO);
			}
			
			DBUtility.closeConnection(null);
			return itemset;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}


	@Override
	public int insertItem(ItemMasterDTO itemDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("dbconfig.properties"));
		ItemMasterDAO obj = new ItemMasterDAOimpl(prop);
		Set<ItemMasterDTO> dto = obj.getAllItemOfCategory(1);
		System.out.println(dto);
	}

}
