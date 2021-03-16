package Assignment;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

public class InvoiceServer extends UnicastRemoteObject implements Invoice {
	
	Scanner s = new Scanner(System.in);
	@Override
	public void startInvoiceApp(int i,int invNo) {
		if(i==1) {
			try {
				createInvoice(invNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(i==2){
			try {
				calculateDate(invNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(i==3){
			try {
				generatePDF(invNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(i==4){
			try {
				generateEXCEL(invNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(i==5){
			try {
				enterItem();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public InvoiceServer() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	public void createInvoice(int i) throws Exception {
		System.out.println("create invoice logic executed.....");
		InvoiceMasterDAOImpl invoice = new InvoiceMasterDAOImpl(DBUtility.getConnection());
		CustomerMasterDAOimpl customer = new CustomerMasterDAOimpl(DBUtility.getConnection());
	
		System.out.print("Invoice  Number: "+invoice.getInvoiceMaster(i).getInvno());
		System.out.print("\tDate: "+invoice.getInvoiceMaster(i).getInvdate());
		System.out.print("\nCustomer Number: "+invoice.getInvoiceMaster(i).getCustomerno());
		
		System.out.print("\tCustomer Name: "+customer.getCustomerMaster(i).getCustName());
		
	}
	public void calculateDate(int i) throws Exception {
		
		System.out.println("delivery date is so and so....");
		InvoiceMasterDAOImpl invoice = new InvoiceMasterDAOImpl(DBUtility.getConnection());
		CustomerMasterDAOimpl customer = new CustomerMasterDAOimpl(DBUtility.getConnection());
		LocalDate date = invoice.getInvoiceMaster(i).getInvdate();
		String address = customer.getCustomerMaster(i).getCustAddress();
		int d = InvoiceServer.getDistance(address);
		InvoiceServer.getFinalDate(date, d);
		
	}
	public void generatePDF(int i) throws Exception {
		System.out.println("Pdf generation logic...");
		
		InvoiceMasterDAOImpl invoice = new InvoiceMasterDAOImpl(DBUtility.getConnection());
		CustomerMasterDAOimpl customer = new CustomerMasterDAOimpl(DBUtility.getConnection());
		
		PdfWriter write = new PdfWriter("D:\\PdfFiles\\Invoice.pdf");
		
		PdfDocument pdfdoc = new PdfDocument(write);
		
		Document doc = new Document(pdfdoc);
		
		float [] pointColumnWidths = {150F, 150F};   
	    Table table = new Table(pointColumnWidths);    
	    
	    // Adding cells to the table 
	    table.addCell(new Cell().add("Invoice Number"));
	    table.addCell(new Cell().add(String.valueOf(invoice.getInvoiceMaster(i).getInvno())));       
	    table.addCell(new Cell().add("Date"));
	    table.addCell(new Cell().add(String.valueOf(invoice.getInvoiceMaster(i).getInvdate())));       
	    table.addCell(new Cell().add("Customer Number"));
	    table.addCell(new Cell().add(String.valueOf(invoice.getInvoiceMaster(i).getCustomerno())));       
	    table.addCell(new Cell().add("Customer Name"));
	    table.addCell(new Cell().add(customer.getCustomerMaster(i).getCustName()));                        
	       
	    // Adding Table to document        
	    doc.add(table);             
		
		doc.close();
		pdfdoc.close();
		write.close();
		
		System.out.println("PDF created....");
	}
	public void generateEXCEL(int i) throws Exception {
		System.out.println("Excel generation logic.....");
		
		Workbook wb = new XSSFWorkbook();
    	Sheet sheet = wb.createSheet();
    	XSSFRow row = (XSSFRow) sheet.createRow(0);
    	XSSFRow row1 = (XSSFRow) sheet.createRow(1);
    	XSSFRow row2 = (XSSFRow) sheet.createRow(2);
    	XSSFRow row3 = (XSSFRow) sheet.createRow(3);
    	
    	OutputStream fileout = new FileOutputStream("D:\\Excelfiles\\Invoice.xlsx");
    	
    	InvoiceMasterDAOImpl invoice = new InvoiceMasterDAOImpl(DBUtility.getConnection());
		CustomerMasterDAOimpl customer = new CustomerMasterDAOimpl(DBUtility.getConnection());
		
		 org.apache.poi.ss.usermodel.Cell cell;
		 	
		 	cell = row.createCell(0);
		  	cell.setCellValue("Invoice Number: ");
		 
		    cell = row.createCell(1);
		    cell.setCellValue(String.valueOf(invoice.getInvoiceMaster(i).getInvno()));
		 
		    cell = row1.createCell(0);
		    cell.setCellValue("Date: ");
		    
		    cell = row1.createCell(1);
		    cell.setCellValue(String.valueOf(invoice.getInvoiceMaster(i).getInvdate()));
		    
		    cell = row2.createCell(0);
		  	cell.setCellValue("Customer No: ");
		 
		    cell = row2.createCell(1);
		    cell.setCellValue(String.valueOf(invoice.getInvoiceMaster(i).getCustomerno()));
		 
		    cell = row3.createCell(0);
		    cell.setCellValue("Customer Name: ");
		    
		    cell = row3.createCell(1);
		    cell.setCellValue(customer.getCustomerMaster(i).getCustName());
    	
		 wb.write(fileout);    
    	System.out.println("Excel created....");
    	
	}
	public void enterItem() throws Exception
	{
		System.out.println("New item entry starts.....");
		
		Scanner s = new Scanner(System.in);
		ItemMasterDTO obj = new ItemMasterDTO();
		ItemMasterDAOimpl im = new ItemMasterDAOimpl(DBUtility.getConnection());
		System.out.println("Enter the item name");
		String str = s.next();
		obj.setItemName(str);
		System.out.println("Enter the item no");
		int a = s.nextInt();
		obj.setItemNo(a);
		System.out.println("Enter the item price");
		int price = s.nextInt();
		obj.setItemPrice(price);
		System.out.println("Enter the item quantity");
		int qty = s.nextInt();
		obj.setItemQuantity(qty);
		
		int i = im.insertItem(obj);
		if(i==1)
		{
			System.out.println("Items are succesfully entered....");
		}
	}
	
	public static void getFinalDate(LocalDate date,int d) {
		int travelSpeed = 10; //km/hr (assumption)... 
		int hr,distance;
		long days;
		
		distance = d;
		hr = distance/travelSpeed;
		System.out.println();
		days = (long)(hr*0.041667);
	
		
		LocalDate customDate = date.plusDays(days);//date.plusDays(days);
		
		System.out.print("\nThe parcel will reach u on "+customDate);

		System.out.println("\nPlease make yourself available...Thank You....");
	}
	
	public static int getDistance(String str) {

		int distance = 0;
		//sample distances...
		//System.out.println(str);
		if(str.equalsIgnoreCase("Salem"))
			distance = 340; //km
		else if(str.equalsIgnoreCase("Coimbatore"))
			distance = 480; //km
		else if(str.equalsIgnoreCase("Bangalore"))
			distance = 340;
		else if(str.equalsIgnoreCase("Pollachi"))
			distance = 540;
		else if(str.equalsIgnoreCase("Pthukottai"))
			distance = 380;
		
		return distance;
	}
}