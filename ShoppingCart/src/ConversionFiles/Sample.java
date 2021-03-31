package ConversionFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sample {
	
	private static Sample samp;

	synchronized public static Sample get() {

		if(samp==null) {
			samp=new samp();
			return samp;
		}
		else {
			return samp.createClone();
		}
	}
	
	synchronized public Sample createClone() {
		try {
			return (Sample)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	public void generatePDF() throws Exception {
		System.out.println("Pdf generation logic...");
		//DBintoTextFile obj = new DBintoTextFile();
		//obj.convertToTextFile(i);
		
		String str = "C:\\Workspace\\eystructs\\WebContent\\invoice.txt";
		
		TxtToXML read = new TxtToXML();
		read.textToXML(str, "C:\\Workspace\\eystructs\\WebContent\\data.xml");
		
		
		XMLtoPDF ob = new XMLtoPDF();
		ob.convertToPDf("C:\\Workspace\\invoice.pdf", "C:\\Workspace\\eystructs\\WebContent\\data.xml");
	
		System.out.println("PDF created....");
	}
	
	public void generateEXCEL() throws Exception {
		System.out.println("Excel generation logic.....");
		
		String str = "C:\\Workspace\\eystructs\\WebContent\\invoice.txt";
		
		TxtToXML read = new TxtToXML();
		read.textToXML(str, "C:\\Workspace\\eystructs\\WebContent\\data.xml");
		
		
		XMLtoExcel ob = new XMLtoExcel();
		ob.convertToExcel("C:\\Workspace\\invoice.xlsx", "C:\\Workspace\\eystructs\\WebContent\\data.xml");
   
    	System.out.println("Excel created....");
    	
	}
	
	public void sendEmail(String email) throws Exception {
	
		//XmlParsing parse = new XmlParsing();
		
		ReadXMLFile parse = new ReadXMLFile();
		
		ArrayList<String> list = parse.readXML("data.xml");
		//ArrayList<String> l = new ArrayList<String>();
		//new MyHandler2();
		//list = MyHandler2.arr;
		String str = list.toString();
		//System.out.println(str);
		
		final String username = "******";
		final String password = "*****"; 
		String from ="*****";
		String to =email;
		
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
		msg.setFrom(new InternetAddress(from));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setSubject("Bill is shared....");
		msg.setText(str);
		Transport.send(msg);
		System.out.println("Message sent...");
	}
	
	public void sendSMS(String no) {
		
        try {
        	
        	ReadXMLFile parse = new ReadXMLFile();
    		
    		ArrayList<String> list = parse.readXML("data.xml");
    		String str = list.get(0)+"\n"+list.get(2)+"\n"+list.get(list.size()-1);
   
        	
            String recipient = no;
            String message = str;//"Hello World..this is a text message";
            String username = "****";
            String password = "****";
            String originator = "*******";

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

            uc.disconnect();

    } catch(Exception ex) {
            System.out.println(ex.getMessage());

    }
}

}
