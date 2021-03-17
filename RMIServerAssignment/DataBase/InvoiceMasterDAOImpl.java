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
public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	private ResultSetMetaData rsmd; 
	Set<InvoiceMasterDTO> set;
	InvoiceMasterDTO invMasterDTO;
	Date date;
	
	
	public InvoiceMasterDAOImpl(Connection con) throws Exception {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/bill","root","gayu");
		this.con = con;
		st = con.createStatement();
	}
	
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
	
		int InvoiceInserted = 0;
		
		try {
			ps = con.prepareStatement("insert into invoice values(?,?,?)");
			ps.setInt(1,invMasterDTO.getInvno());
			Date x = Date.valueOf(invMasterDTO.getInvdate());
			ps.setDate(2, x);
			ps.setInt(3,invMasterDTO.getCustomerno());
			
			InvoiceInserted = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return InvoiceInserted;
	}
	@Override
	public int deleteInvoice(int invno) {
		int invDeleted  = 0;
		try {
			ps = con.prepareStatement("delete from invoice where invNo=?");
			ps.setInt(1, invno);
			invDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		return invDeleted;
	}
	
	@Override
	public int updateInvoice(InvoiceMasterDTO invMasterDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invo) {
	
		try {
			ps = con.prepareStatement("select * from invoice where invNo=?");
			ps.setInt(1, invo);
			rs = ps.executeQuery();
			
			invMasterDTO = new InvoiceMasterDTO();
		
			while(rs.next()) {
				invMasterDTO.setInvno(rs.getInt(1));
				LocalDate d = rs.getDate(2).toLocalDate();//date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				invMasterDTO.setInvdate(d);
				invMasterDTO.setCustomerno(rs.getInt(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(invMasterDTO);
		return invMasterDTO;
	}
	
	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		
		set = new HashSet<InvoiceMasterDTO>();

		
		try {
			rs = st.executeQuery("SELECT COUNT(*) AS rowcount FROM invoice");
			rs.next();
			int count = rs.getInt("rowcount") ;
			rs.close() ;
			System.out.println("MyTable has " + count + " row(s).");
			
			for(int i=1;i<=count;i++) {
				invMasterDTO = getInvoiceMaster(i);
				//System.out.println(invMasterDTO);
				set.add(invMasterDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
		
	}
	
}
