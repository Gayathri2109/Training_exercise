package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;


@WebService(endpointInterface = "Services.PdfService")
public class PdfServiceimpl implements PdfService {

	@WebMethod
	@Override
	public File GeneratePDF(String xml, String pdfloc) {
	
		try {
			
			PdfWriter write = new PdfWriter(pdfloc);
			PdfDocument pdfdoc = new PdfDocument(write);
			Document doc = new Document(pdfdoc);
			ArrayList<String> arr = new PdfServiceimpl().readXML(xml);
			//Paragraph para = new Paragraph(arr.toString());
			

			
			float [] pointColumnWidths = {150F};   
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
		
			
			return new File(pdfloc);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@WebMethod
	@Override
	public ArrayList<String> readXML(String file){
		
		ArrayList<String> userList = new ArrayList<String>();
    
		try {

    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();

    DefaultHandler handler = new DefaultHandler() {

    boolean bfname = false;
  

    public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("option")) {
            bfname = true;
        }

    }

    public void characters(char ch[], int start, int length) throws SAXException {

        if (bfname) {
        	String str = new String(ch, start, length);
            //System.out.println(str);
            userList.add(str);
            bfname = false;
        } }

     };

       saxParser.parse(file, handler);
       
       
 
     } catch (Exception e) {
       e.printStackTrace();
     }
		//System.out.println(userList);
		return userList;
   }

	@WebMethod
	@Override
	public File GenerateExcelFile(String xml, String xcelloc) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream(xcelloc);
			XSSFWorkbook workbook= new XSSFWorkbook();
			XSSFSheet sheet= workbook.createSheet();
			
			ArrayList arr = new PdfServiceimpl().readXML(xml);
			XSSFRow  row;
			int a = 0;
			int n = arr.size();
			
			for(int j=0;j<n;j++)
			{
				row = sheet.createRow(a);
				row.createCell(0).setCellValue(arr.get(j).toString());
				a++;
			}
			
			
			workbook.write(fileOut);    
			fileOut.close();    
			workbook.close(); 
			
			return new File(xcelloc);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		return null;
	}
	
	
	@WebMethod
	@Override
	public boolean sendEmail(String tomail,String xml) {

	ArrayList<String> list = new PdfServiceimpl().readXML(xml);
	boolean b = false;
	String str = list.toString();
	
	
	final String username = "lpgayathri21@gmail.com";
	final String password = "gayathri@21"; 
	String from ="lpgayathri21@gmail.com";
	String to = tomail;
	
	Properties prop = new Properties();
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.starttls.enable", "true");
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.port", "587");

	Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(username, password);
	    }
	});
	
	MimeMessage msg = new MimeMessage(session);

	try {
		msg.setFrom(new InternetAddress(from));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setSubject("Bill is shared....");
		msg.setText(str);
		Transport.send(msg);
		b = true;
		System.out.println("Message sent...");
		
		return b;
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return b;
	}
	
	@WebMethod
	@Override
	public boolean sendSMS(String no,String xml) {
		
		boolean b = false;
        try {
        	
    		ArrayList<String> list = new PdfServiceimpl().readXML(xml);
    		String str = list.get(0)+"\n"+list.get(2)+"\n"+list.get(list.size()-1);
    		
        	
            String recipient = no;
            String message = str;//"Hello World..this is a text message";
            String username = "****";
            String password = "****";
            String originator = "+36201234567";

            String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
				"username=" + URLEncoder.encode(username, "UTF-8") +
				"&password=" + URLEncoder.encode(password, "UTF-8") +
				"&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
				"&messagetype=SMS:TEXT" +
				"&messagedata=" + URLEncoder.encode(message, "UTF-8") +
				"&originator=" + URLEncoder.encode(originator, "UTF-8") +
				"&serviceprovider=HTTPServer0" +
				"&responseformat=html";



            URL url = new URL(requestUrl);
            HttpURLConnection uc = (HttpURLConnection)url.openConnection();

            System.out.println(uc.getResponseMessage());
            b = true;
            uc.disconnect();

            return b;
            
    } catch(Exception ex) {
            System.out.println(ex.getMessage());

    }
        
        return b;
	}
}

