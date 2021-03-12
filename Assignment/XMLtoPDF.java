
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


interface PDFConverter{
	public void convertToPDf(String str,String file);
}

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
		
		
		XMLParser p = new XMLParser();
		ArrayList arr = p.getXmlContent(file);
		Paragraph para = new Paragraph(arr.toString());
		
		doc.add(para);             
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
