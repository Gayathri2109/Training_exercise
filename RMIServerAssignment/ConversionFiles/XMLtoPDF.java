package ConversionFiles;

import java.util.ArrayList;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

public class XMLtoPDF implements PDFConverter{

	private static XMLtoPDF obj;
	
	//public static void main(String[] args) throws Exception {
	
		@Override
		public void convertToPDf(String str,String file) {
			try {
				createXMLtoPDF(str,file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void createXMLtoPDF(String str,String file) throws Exception {
			
		PdfWriter write = new PdfWriter(str);
		PdfDocument pdfdoc = new PdfDocument(write);
		Document doc = new Document(pdfdoc);
		
		
		ReadXMLFile p = new ReadXMLFile();
		ArrayList arr = p.readXML(file);
		//Paragraph para = new Paragraph(arr.toString());
		

		
		float [] pointColumnWidths = {150F, 150F};   
	    Table table = new Table(pointColumnWidths);    
	    
	    // Adding cells to the table 
	   
	    for(int i=0;i<arr.size();i++)
	    table.addCell(new Cell().add(arr.get(i).toString()));       
 
	    // Adding Table to document        
	    doc.add(table);  
		
		
		//doc.add(para);             
		doc.close();
		pdfdoc.close();
		write.close();
		
		System.out.println("PDF file created....");
		
	}
		
	public static XMLtoPDF getObj() {
		if(obj == null)
			return new XMLtoPDF();
		return obj;
	}
}
