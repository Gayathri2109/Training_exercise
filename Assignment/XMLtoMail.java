
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


interface Mail{
	public void sendMail(String str);
}

public class XMLtoMail implements Mail{

	private static XMLtoMail obj;
	
	@Override
	public void sendMail(String str) {
		try {
			sendEmail(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEmail(String file) throws Exception {
	
		XMLParser p = new XMLParser();
		ArrayList arr = p.getXmlContent(file);
		
		final String username = "username";
		final String password = "******"; 
		String from ="*****@gmail.com";
		String to ="******@gmail.com";
		
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
		msg.setText(arr.toString());
		Transport.send(msg);
		System.out.println("Message sent...");
	}
	
	public static XMLtoMail getObj() {
		if(obj == null)
			return new XMLtoMail();
		return obj;
	}

}
