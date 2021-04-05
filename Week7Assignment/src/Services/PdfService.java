package Services;

import java.io.File;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PdfService {

	@WebMethod
	public File GeneratePDF(String xml,String pdfloc);
	@WebMethod
	public ArrayList<String> readXML(String file);
	@WebMethod
	public File GenerateExcelFile(String xml,String xcelloc); 
	@WebMethod
	public boolean sendEmail(String to,String xml);
	@WebMethod
	public boolean sendSMS(String no,String xml);
}
