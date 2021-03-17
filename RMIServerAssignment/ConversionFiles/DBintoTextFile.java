package ConversionFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

import DataBase.CustomerMasterDAOimpl;
import DataBase.DBUtility;
import DataBase.InvoiceMasterDAOImpl;
import DataBase.ItemMasterDAOimpl;
import DataBase.ItemTransactionDAOimpl;

public class DBintoTextFile {

	public void convertToTextFile(int i) throws Exception
	{
		InvoiceMasterDAOImpl invoice = new InvoiceMasterDAOImpl(DBUtility.getConnection());
		CustomerMasterDAOimpl customer = new CustomerMasterDAOimpl(DBUtility.getConnection());
		ItemMasterDAOimpl item = new ItemMasterDAOimpl(DBUtility.getConnection());
		ItemTransactionDAOimpl transac = new ItemTransactionDAOimpl(DBUtility.getConnection());

		String invNo = String.valueOf(invoice.getInvoiceMaster(i).getInvno());
		int itNo = transac.getItemMaster(i).getItemNo(); 
		String date = String.valueOf(invoice.getInvoiceMaster(i).getInvdate());
		String custNo = String.valueOf(invoice.getInvoiceMaster(i).getCustomerno());
		String custName = customer.getCustomerMaster(i).getCustName();
		String itemNo = String.valueOf(item.getItemMaster(itNo).getItemNo());
		String itemName = item.getItemMaster(itNo).getItemName();
		String itemPrice = String.valueOf(item.getItemMaster(itNo).getItemPrice());
		String itemQuantity = String.valueOf(item.getItemMaster(itNo).getItemQuantity());
		String Total = String.valueOf(Integer.parseInt(itemPrice)*Integer.parseInt(itemQuantity));
		
		StringBuilder sb = new StringBuilder();
		sb.append("Invoice  Number: "+invNo+",");
		sb.append("Date: "+date+",");
		sb.append("Customer Number: "+custNo+",");
		sb.append("Customer Name: "+custName+",");
		sb.append("Item No: "+itemNo+",");
		sb.append("Item Name: "+itemName+",");
		sb.append("Item Quantity: "+itemQuantity+",");
		sb.append("Item Price: "+itemPrice+",");
		sb.append("Total Amount: "+Total);
		FileOutputStream fos = new FileOutputStream("data.txt");
		
		StringTokenizer st = new StringTokenizer(sb.toString(),",");
		String arr[] = new String[50];
		int count =0;
		while(st.hasMoreElements())
		{
			arr[count] = st.nextToken().toString();
			count++;
		}
		
		for(int j=0;j<count;j++)
		{
			fos.write(arr[j].getBytes());
			fos.write("\n".getBytes());
		}
		System.out.println("\nFile created....");
		fos.close();
		DBUtility.closeConnection(null);
	}
	
	public File getTextFile()
	{
		return new File("data.txt");
	}
}
