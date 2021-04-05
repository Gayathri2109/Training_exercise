package Services;

import javax.xml.ws.Endpoint;



public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:3015/ws",new PdfServiceimpl());
		
		//Endpoint.publish("http://localhost:3012/ws",new testServiceimpl());
				
		System.out.println("Service Published..........");
	}
}
