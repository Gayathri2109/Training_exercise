package DataBase;

import java.rmi.Naming;
import java.util.Scanner;
public class InvoiceClient {
	public static void main(String[] args) throws Exception{
		
		Invoice inv=(Invoice)Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		Scanner scan=new Scanner(System.in);
		System.out.println("Please select your choice...");
		System.out.println("1-Create new Invoice");
		System.out.println("2-Calculate Delivery date and time");
		System.out.println("3-To generate PDF of Invoice");
		System.out.println("4-To generate Excel of Invoice");
		System.out.println("5-To enter new items");
		
		int choice=scan.nextInt();
		
		System.out.println("Enter the invoice Number?");
		int n = scan.nextInt();
		
		switch(choice) {
		case 1:{
			inv.startInvoiceApp(1,n);
			break;
		}
		case 2:{
			inv.startInvoiceApp(2,n);
			break;
		}
		case 3:{
			inv.startInvoiceApp(3,n);
			break;
		}
		case 4:{
			inv.startInvoiceApp(4,n);
			break;
		}
		case 5:{
			inv.startInvoiceApp(5,n);
			break;
		}
		default:
			System.out.println("wrong choice...");
		}
		
	}
}