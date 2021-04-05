package Services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface testService {

	@WebMethod
	public String display();
}
