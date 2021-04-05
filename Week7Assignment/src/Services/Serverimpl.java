package Services;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Serverimpl extends UnicastRemoteObject implements Server{

	public Serverimpl() throws RemoteException {
		//super();
	}

	@Override
	public String getServer() throws RemoteException{
		
		try {
			URL url = new URL("http://localhost:3015/ws?wsdl");
			QName qname = new QName("http://Services/","PdfServiceimplService");
			
			Service service = Service.create(url,qname);
			PdfService hservice=service.getPort(PdfService.class);
			
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Please select your choice...");
			System.out.println("1-To generate PDF");
			System.out.println("2-To generate Excel");
			System.out.println("3-To send an email");
			System.out.println("4-To send an sms");
			
			int choice=scan.nextInt();
			
			//Scanner scan = new Scanner(System.in);
			String xml = "C:\\Workspace\\Week7Assignment\\WebContent\\data.xml";
			
			
			
			switch(choice) {
			case 1:{
				 File file = hservice.GeneratePDF(xml, "C:\\Workspace\\sample.pdf");
				 if(file.exists()==true)
					 System.out.println("Pdf successfully created.....");
				 else
					 System.out.println("Pdf not created.....");
				break;
			}
			case 2:{
				 File file = hservice.GenerateExcelFile(xml, "C:\\Workspace\\sample.xlsx");
				 if(file.exists()==true)
					 System.out.println("Excel successfully created.....");
				 else
					 System.out.println("Excel not created.....");
				break;
			}
			case 3:{
				
				System.out.println("Enter your email....");
				String email = scan.next();
				boolean b = hservice.sendEmail(email, xml);
				if(b)
					System.out.println("Mail sent......");
				else
					System.out.println("Mail not sent.......");
				break;
			}
			case 4:{
				
				System.out.println("Enter your Phone No....");
				String no = scan.next();
				boolean b = hservice.sendSMS(no, xml);
				if(b)
					System.out.println("Message sent......");
				else
					System.out.println("Message not sent.......");
				break;
			}
			default:{
				System.out.println("Wrong choice...");
			}
			
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) throws RemoteException {
//		Serverimpl s = new Serverimpl();
//		s.getServer(0);
//	}
}

