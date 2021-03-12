import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


interface SMS{
	public void sendMSG(String str);
}

public class XMLtoSMS implements SMS{

		private static XMLtoSMS obj;
		
		@Override
		public void sendMSG(String str) {
			sendMSG(str);
		}
		
        public void sendSMS(String file) throws Exception {
        	
    		XMLParser p = new XMLParser();
    		ArrayList arr = p.getXmlContent(file);
 
    		
        	try {
                        String recipient = "+36205555555";
                        String message = arr.toString();
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
 
                        uc.disconnect();
 
                } catch(Exception ex) {
                        System.out.println(ex.getMessage());
 
                }
        }
        
        public static XMLtoSMS getObj() {
        	if(obj == null)
        		return new XMLtoSMS();
        	return obj;
        }
 
}
