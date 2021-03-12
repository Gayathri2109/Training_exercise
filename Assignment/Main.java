

//XML to PDF - converting class

public class Main {
	public static void main(String[] args) throws Exception {
		
		ExcelConverter o1 = XMLtoExcel.getObj();
		o1.convertToExcel("D:\\Excelfiles\\Invoice.xlsx", "bill.xml");
		
		PDFConverter o2 = XMLtoPDF.getObj();
		o2.convertToPDf("D:\\Pdffiles\\Invoice.pdf", "bill.xml");
		
		Mail o3 = XMLtoMail.getObj();
		o3.sendMail("bill.xml");
		
		SMS o4 = XMLtoSMS.getObj();
		o4.sendMSG("bill.xml");
 }
}



