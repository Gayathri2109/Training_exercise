
import java.util.ArrayList;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void main(String[] args) throws Exception {
	
		XmlParsing parse = new XmlParsing();
		ArrayList<String> list = new ArrayList<String>();
		//ArrayList<String> l = new ArrayList<String>();
		new MyHandler2();
		list = MyHandler2.arr;
		String str = list.toString();
		//System.out.println(str);
		
		final String username = "****";
		final String password = "*****"; 
		String from ="*****@gmail.com";
		String to ="****@gmail.com";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
//		Session session = Session.getInstance(prop, new Authenticator() {
//			
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		});
	
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

}
