package Services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "Services.testService")
public class testServiceimpl implements testService {

	@WebMethod
	@Override
	public String display() {
		return "Helooo..i am working.......";
		
	}
	
}
